package ui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
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
    private TextField tfBrojRacuna;

    @FXML
    private TextField tfImeBanke;

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
    public void pretraziRacun(ActionEvent actionEvent) throws IOException, SQLException {

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
                String sql;

                if(tfBrojRacuna.getText().isEmpty() && tfImeBanke.getText().isEmpty())
                    sql = "select * from racunubanci";
                else if(!tfBrojRacuna.getText().isEmpty() && tfImeBanke.getText().isEmpty())
                    sql = "select * from racunubanci where brojRacuna like \'"+tfBrojRacuna.getText().toString()
                            + "\'";
                else if (tfBrojRacuna.getText().isEmpty() && !tfImeBanke.getText().isEmpty())
                    sql = "select * from racunubanci where imeBanke like \'"+tfImeBanke.getText().toString()
                            + "\'";
                else
                    sql = "select * from racunubanci where brojRacuna like \'"+tfBrojRacuna.getText().toString()
                            + "\' and imeBanke like \'"+tfImeBanke.getText().toString() +"\'";
                System.out.println(sql);
                p = myConn.prepareStatement(sql);
                myRS = p.executeQuery();
                int c = 0;
                while(myRS.next()){
                    //System.out.println("KLIJENT");
                    c=1;
                    int id = myRS.getInt("idRacunUBanci");
                    String imeBanke = myRS.getString("imeBanke");
                    int brojRacuna = myRS.getInt("brojRacuna");

                    Racun racun = new Racun(id,brojRacuna,imeBanke);
                    System.out.println(racun.getBroj());
                    list.add(racun);
                    tvRacun.setItems(list);
                }
                if(c==0) tvRacun.setItems(null);
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
