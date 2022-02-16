package ui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import ui.model.Klijent;
import ui.model.Racun;
import ui.ui2021.App;

import java.io.IOException;
import java.sql.*;

public class RacunController {


    @FXML
    private Button btAddRacun;

    @FXML
    private Button btDeleteRacun;

    @FXML
    private Button btIzmeniRacun;

    @FXML
    private Button btPozajmicaRacunovodja;

    @FXML
    private Button btnPretrazi;

    @FXML
    private ComboBox cbBrojRacuna;

    @FXML
    private ComboBox cbId;

    @FXML
    private ComboBox cbImeBanke;

    @FXML
    private Pane idRacunRacunovodja;

    @FXML
    private TableColumn<Racun, Integer> tcBrojRacuna;

    @FXML
    private TableColumn<Racun, Integer> tcId;

    @FXML
    private TableColumn<Racun, String> tcImeBanke;

    @FXML
    private TableView<Racun> tvRacun;

    @FXML
    public void initialize() {
        tcId.setCellValueFactory(new PropertyValueFactory("id"));
        tcBrojRacuna.setCellValueFactory(new PropertyValueFactory("broj"));
        tcImeBanke.setCellValueFactory(new PropertyValueFactory("imeBanke"));
        //System.out.println("USO JE Ovde Scene BilderFaktura");
        try {
            ucitajRacune();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void pozajmica(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/pozajmica.fxml");
    }

    public void addRacun(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addRacun.fxml");
    }

    public void izmeniRacun(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniRacun.fxml");
    }

    public void deleteRacun(ActionEvent actionEvent) throws SQLException {
        Racun racun = tvRacun.getSelectionModel().getSelectedItem();
        //System.out.println(klijent.getId());
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            //System.out.println("prosoAddKlijent");
            Statement stmt = myConn.createStatement();
            String sql = "DELETE FROM racunubanci WHERE idRacunUBanci = " + racun.getId();
            System.out.println(sql);
            stmt.executeUpdate(sql);
            changeContent("racunovodja/racun.fxml");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }finally {
            if(myConn != null){
                myConn.close();
            }
        }
        ucitajRacune();
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idRacunRacunovodja.getChildren().removeAll();
        idRacunRacunovodja.getChildren().addAll((root));
    }
    private void ucitajRacune() throws SQLException {
        ObservableList<Racun> list = FXCollections.observableArrayList();
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("prosoKlijent");
            String sql = "select * from racunubanci";
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();

            while(myRS.next()){
                //System.out.println("KLIJENT");

                int id = myRS.getInt("idRacunUBanci");
                String imeBanke = myRS.getString("imeBanke");
                int brojRacuna = myRS.getInt("brojRacuna");

                Racun racun = new Racun(id,brojRacuna,imeBanke);
                System.out.println(racun.getBroj());
                list.add(racun);
                tvRacun.setItems(list);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(myConn != null){
                myConn.close();
            }
            if(myRS != null){
                myRS.close();
            }
        }
    }

}
