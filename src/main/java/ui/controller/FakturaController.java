package ui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import ui.model.Faktura;
import ui.model.Klijent;
import ui.ui2021.App;

import java.io.IOException;
import java.sql.*;

public class FakturaController {

    @FXML
    private Pane idFakturaRacunovodjaPane;

    @FXML
    private Button btAddFaktura;

    @FXML
    private Button btIzmeniFakturu;


    @FXML
    private TableColumn<Faktura, Date> tcDatumKreiranja;

    @FXML
    private TableColumn<Faktura, Integer> tcId;

    @FXML
    private TableColumn<Faktura, Integer> tcIdKlijenta;

    @FXML
    private TableColumn<Faktura, Integer> tcIdPDV;

    @FXML
    private TableColumn<Faktura, Integer> tcIdStavke;

    @FXML
    private TableColumn<Faktura, Integer> tcKolicina;

    @FXML
    private TableColumn<Faktura, String> tcOpis;

    @FXML
    private TableColumn<Faktura, Integer> tcSuma;

    @FXML
    private TableColumn<Faktura, String> tcTipFakture;

    @FXML
    private TableColumn<Faktura, String> tcTipUplate;

    @FXML
    private TableView<Faktura> tvFaktura;
    @FXML
    public void initialize() {
        tcId.setCellValueFactory(new PropertyValueFactory("id"));
        tcDatumKreiranja.setCellValueFactory(new PropertyValueFactory("datum"));
        tcIdKlijenta.setCellValueFactory(new PropertyValueFactory("idKlijent"));
        tcIdPDV.setCellValueFactory(new PropertyValueFactory("idPdv"));
        tcIdStavke.setCellValueFactory(new PropertyValueFactory("idStavka"));
        tcKolicina.setCellValueFactory(new PropertyValueFactory("kolicina"));
        tcOpis.setCellValueFactory(new PropertyValueFactory("opis"));
        tcTipUplate.setCellValueFactory(new PropertyValueFactory("uplatilacTip"));
        tcTipFakture.setCellValueFactory(new PropertyValueFactory("tipFakture"));
        tcSuma.setCellValueFactory(new PropertyValueFactory("suma"));
        System.out.println("USO JE Ovde Scene BilderFaktura");
        try {
            ucitajFakture();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addFaktura(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addFaktura.fxml");
        //App.getInstance().getMyConn();
    }

    public void izmeniFakturu(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniFakturu.fxml");
    }

    public void deleteFaktura(ActionEvent actionEvent) throws SQLException {

    }


    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idFakturaRacunovodjaPane.getChildren().removeAll();
        idFakturaRacunovodjaPane.getChildren().addAll((root));
    }
    private void ucitajFakture() throws SQLException {
        ObservableList<Faktura> list = FXCollections.observableArrayList();
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("prosoFaktura");
            String sql = "select * from faktura";
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();

            while(myRS.next()){
                //System.out.println("KLIJENT");

                int id = myRS.getInt("idFaktura");
                int kolicina = myRS.getInt("kolicina");
                int suma = myRS.getInt("suma");
                String tipFakture = myRS.getString("tipFakture");
                String opis = myRS.getString("opis");
                Date date = myRS.getDate("datumKreiranja");
                int idKlijent = myRS.getInt("Klijent_idKlijent");
                String uplatilac = myRS.getString("Uplatilac_Primalac");
                int pdv = myRS.getInt("PDV_idPDV");
                int stavka = myRS.getInt("Stavka_idStavka");

                Faktura faktura = new Faktura(id, kolicina, suma, tipFakture, opis, date, idKlijent, uplatilac,pdv,stavka);
                list.add(faktura);
                tvFaktura.setItems(list);
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
