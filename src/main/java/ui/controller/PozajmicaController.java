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
import ui.model.Pozajmica;
import ui.model.Racun;
import ui.ui2021.App;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class PozajmicaController {


    @FXML
    private Pane idRacunRacunovodja;

    @FXML
    private Button btPretrazi;

    @FXML
    private DatePicker btDatumPretrazi;

    @FXML
    private Button btAddPozajmica;

    @FXML
    private Button btIzmeniPozajmica;

    @FXML
    private Button btDeletePozajmica;

    @FXML
    private TableColumn<Racun, Integer> tcId;

    @FXML
    private TableColumn<Racun, String> tcPrincipal;

    @FXML
    private TableColumn<Racun, String> tcInterest;

    @FXML
    private TableColumn<Racun, LocalDate> tcDatum;

    @FXML
    private TableColumn<Racun, String> tcOpis;

    @FXML
    private TableView<Pozajmica> tvPozajmica;

    @FXML
    public void initialize() {
        tcId.setCellValueFactory(new PropertyValueFactory("id"));
        tcPrincipal.setCellValueFactory(new PropertyValueFactory("principal"));
        tcInterest.setCellValueFactory(new PropertyValueFactory("interest"));
        tcDatum.setCellValueFactory(new PropertyValueFactory("datum"));
        tcOpis.setCellValueFactory(new PropertyValueFactory("opis"));

        //System.out.println("USO JE Ovde Scene BilderFaktura");
        try {
            ucitajPozajmice();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addPozajmica(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addPozajmica.fxml");
    }

    public void izmeniPozajmica(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniPozajmica.fxml");
    }

    public void filterPozajmica(ActionEvent actionEvent) throws IOException, SQLException {
        LocalDate datumDate = btDatumPretrazi.getValue();
        ObservableList<Pozajmica> list = FXCollections.observableArrayList();

        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            //System.out.println("prosoAddKlijent");
            Statement stmt = myConn.createStatement();
            String sql = "select * from pozajmica WHERE datum = '" + datumDate + "'";
            System.out.println(sql);
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();

            while(myRS.next()){
                //System.out.println("KLIJENT");

                int id = myRS.getInt("idPozajmica");
                String principal = myRS.getString("principal");
                String interest = myRS.getString("interest");
                Date datum = myRS.getDate("datum");
                String opis = myRS.getString("opis");

                Pozajmica pozajmica = new Pozajmica(id,principal,interest,datum,opis);
                System.out.println(pozajmica.getId());
                list.add(pozajmica);
                tvPozajmica.setItems(list);
            }
//            changeContent("racunovodja/pozajmica.fxml");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(myConn != null){
                myConn.close();
            }
        }
    }

    public void deletePozajmica(ActionEvent actionEvent) throws SQLException {
        Pozajmica pozajmica = tvPozajmica.getSelectionModel().getSelectedItem();
        //System.out.println(klijent.getId());

        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        Connection myConn = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            //System.out.println("prosoAddKlijent");
            Statement stmt = myConn.createStatement();
            String sql = "DELETE FROM pozajmica WHERE idPozajmica = " + pozajmica.getId();
            System.out.println(sql);
            stmt.executeUpdate(sql);
            changeContent("racunovodja/pozajmica.fxml");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }finally {
            if(myConn != null){
                myConn.close();
            }
        }
        ucitajPozajmice();
    }
    private void ucitajPozajmice() throws SQLException {
        ObservableList<Pozajmica> list = FXCollections.observableArrayList();
        String dbURL = "jdbc:mysql://localhost:3306/mydb";

        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("prosaoKlijent");
            String sql = "select * from pozajmica";
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();

            while(myRS.next()){
                //System.out.println("KLIJENT");

                int id = myRS.getInt("idPozajmica");
                String principal = myRS.getString("principal");
                String interest = myRS.getString("interest");
                Date datum = myRS.getDate("datum");
                String opis = myRS.getString("opis");

                Pozajmica pozajmica = new Pozajmica(id,principal,interest,datum,opis);
                System.out.println(pozajmica.getId());
                list.add(pozajmica);
                tvPozajmica.setItems(list);
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

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idRacunRacunovodja.getChildren().removeAll();
        idRacunRacunovodja.getChildren().addAll((root));
    }


}
