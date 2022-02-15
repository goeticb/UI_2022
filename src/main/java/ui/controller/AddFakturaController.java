package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;
import java.sql.*;

public class AddFakturaController {

    @FXML
    private Pane idAddFakturaRacunovodjaPane;

    @FXML
    private Button btDodajKupca;

    @FXML
    private Button btDodajDobavljaca;

    @FXML
    private Button btSaveFaktura;

    @FXML
    private Button btDodajArtikal;

    @FXML
    private Button btDodajPdv;

    @FXML
    private ComboBox cbKlijent;

    @FXML
    private ComboBox cbArtikal;

    @FXML
    private TextField tfKolicina;

    @FXML
    private TextField tfOpis;

    @FXML
    private RadioButton rbIzlazne;

    @FXML
    private RadioButton rbUlazne;

    @FXML
    private RadioButton silazne;
    @FXML
    public void initialize() throws SQLException {

        System.out.println("USO JE Ovde Scene BilderAddFaktura");
        //-------------------------------------------------
        //Dodavanje klijenata i artikala u ComboBox
        cbKlijent.getItems().removeAll(cbKlijent.getItems());
        cbArtikal.getItems().removeAll(cbArtikal.getItems());
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;

        try {
            myConn = DriverManager.getConnection(dbURL, user, pass);
            String sql = "select * from klijent";
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();

            while(myRS.next()){
                //System.out.println("KLIJENT");

                int id = myRS.getInt("idDobavljac");
                String nazivKlijenta = myRS.getString("nazivKlijenta");
                String adresaKlijenta = myRS.getString("adresaKlijenta");
                int racunKlijenta = myRS.getInt("racunKlijenta");

                String temp = id + " " + nazivKlijenta + " " + adresaKlijenta + " " + racunKlijenta;
                //System.out.println(temp);
                cbKlijent.getItems().add(temp);
            }

            sql = "select * from stavka";
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();

            while(myRS.next()){
                //System.out.println("KLIJENT");

                int id = myRS.getInt("idStavka");
                String nazivStavke = myRS.getString("nazivStavke");
                String jm = myRS.getString("jm");
                int cena = myRS.getInt("cena");

                String temp = id + " " + nazivStavke + " " + cena + " " + jm;
                //System.out.println(temp);
                cbArtikal.getItems().add(temp);
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

    public void addArtikal(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addArtikal.fxml");
    }

    public void addKlijent(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addKlijent.fxml");
    }

    public void saveFaktura(ActionEvent actionEvent) throws IOException, SQLException {

        int kolicina = Integer.parseInt(tfKolicina.getText());
        String opis = tfOpis.getText();
        int pdvId = 1;

        String artikal = cbArtikal.getValue().toString();
        String[] artikalTemp = artikal.split(" ");
        int artikalId = Integer.parseInt(artikalTemp[0]);

        String klijent = cbKlijent.getValue().toString();
        String[] klijentTemp = artikal.split(" ");
        int klijentId = Integer.parseInt(artikalTemp[0]);

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);

        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;

        try {
            myConn = DriverManager.getConnection(dbURL, user, pass);
            Statement stmt = myConn.createStatement();
            //String sql = "INSERT INTO klijent (nazivKlijenta, adresaKlijenta, racunKlijenta) VALUES ('"+ nazivKlijenta +"', '"+ adresa +"', "+racun + ")";
            //System.out.println(sql);
            //stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(myConn != null){
                myConn.close();
            }
        }

        changeContent("racunovodja/addKonto.fxml");
    }

    public void addPdv(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addPdv.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idAddFakturaRacunovodjaPane.getChildren().removeAll();
        idAddFakturaRacunovodjaPane.getChildren().addAll((root));
    }
}
