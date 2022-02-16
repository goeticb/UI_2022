package ui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import ui.model.Klijent;
import ui.ui2021.App;

import java.sql.*;

import java.io.IOException;
import java.sql.SQLException;

public class KlijentiController {

    @FXML
    private Button brObrisiKlijenta;

    @FXML
    private Button btAddKlijent;

    @FXML
    private Button btIzmeniKlijenta;

    @FXML
    private Button btPretrazi;

    @FXML
    private HBox dpDo;

    @FXML
    private Pane idKlijentiPane;

    @FXML
    private TableView<Klijent> tvKlijent;

    @FXML
    private TableColumn<Klijent, String> tcAdresa;

    @FXML
    private TableColumn<Klijent, Integer> tcId;

    @FXML
    private TableColumn<Klijent, String> tcIme;

    @FXML
    private TableColumn<Klijent, Integer> tcRacun;

    @FXML
    private TextField tfAdresa;

    @FXML
    private TextField tfNaziv;

    @FXML
    private TextField tfRacun;


    @FXML
    public void initialize() {
        tcId.setCellValueFactory(new PropertyValueFactory("id"));
        tcIme.setCellValueFactory(new PropertyValueFactory("naziv"));
        tcAdresa.setCellValueFactory(new PropertyValueFactory("adresa"));
        tcRacun.setCellValueFactory(new PropertyValueFactory("racun"));
        System.out.println("USO JE Ovde Scene BilderFaktura");
        try {
            ucitajKlijente();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addKlijent(ActionEvent actionEvent) throws IOException, SQLException {

        changeContent("racunovodja/addKlijent.fxml");
    }

    public void izmeniKlijenta(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniKlijenta.fxml");
    }

    public void deleteKlijent(ActionEvent actionEvent) throws IOException, SQLException {
        Klijent klijent = tvKlijent.getSelectionModel().getSelectedItem();
        //System.out.println(klijent.getId());
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("prosoAddKlijent");
            Statement stmt = myConn.createStatement();
            String sql = "DELETE FROM klijent WHERE idDobavljac = " + klijent.getId();
            System.out.println(sql);
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(myConn != null){
                myConn.close();
            }
        }
        ucitajKlijente();
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idKlijentiPane.getChildren().removeAll();
        idKlijentiPane.getChildren().addAll((root));
    }
    private void ucitajKlijente() throws SQLException {
        ObservableList<Klijent> list = FXCollections.observableArrayList();
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("prosoKlijent");
            String sql = "select * from klijent";
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();

            while(myRS.next()){
                //System.out.println("KLIJENT");

                int id = myRS.getInt("idDobavljac");
                String nazivKlijenta = myRS.getString("nazivKlijenta");
                String adresaKlijenta = myRS.getString("adresaKlijenta");
                int racunKlijnta = myRS.getInt("racunKlijenta");

                Klijent klijent = new Klijent(id, nazivKlijenta, adresaKlijenta, racunKlijnta);
                list.add(klijent);
                tvKlijent.setItems(list);
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

    public void filtrirajKlijentaPoImenu(String naziv) throws SQLException {
        ObservableList<Klijent> list = FXCollections.observableArrayList();
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("prosoKlijent");
            String sql = "select * from klijent where nazivKlijenta = " + naziv;
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();

            while(myRS.next()){
                //System.out.println("KLIJENT");

                int id = myRS.getInt("idDobavljac");
                String nazivKlijenta = myRS.getString("nazivKlijenta");
                String adresaKlijenta = myRS.getString("adresaKlijenta");
                int racunKlijnta = myRS.getInt("racunKlijenta");

                Klijent klijent = new Klijent(id, nazivKlijenta, adresaKlijenta, racunKlijnta);
                list.add(klijent);
                tvKlijent.setItems(list);
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

    public void filtrirajKlijentaPoAdresi(String adresa) throws SQLException {
        ObservableList<Klijent> list = FXCollections.observableArrayList();
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("prosoKlijent");
            String sql = "select * from klijent where adresaKlijenta = " + adresa;
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();

            while(myRS.next()){
                //System.out.println("KLIJENT");

                int id = myRS.getInt("idDobavljac");
                String nazivKlijenta = myRS.getString("nazivKlijenta");
                String adresaKlijenta = myRS.getString("adresaKlijenta");
                int racunKlijnta = myRS.getInt("racunKlijenta");

                Klijent klijent = new Klijent(id, nazivKlijenta, adresaKlijenta, racunKlijnta);
                list.add(klijent);
                tvKlijent.setItems(list);
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
