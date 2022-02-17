package ui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import ui.model.Konto;
import ui.model.Pozajmica;
import ui.model.Racun;
import ui.ui2021.App;

import java.io.IOException;
import java.sql.*;

public class KontoController {

    @FXML
    private Pane idKontoPane;

    @FXML
    private TableColumn<Racun, Integer> tcId;

    @FXML
    private TableColumn<Racun, String> tcSifra;

    @FXML
    private TableColumn<Racun, String> tcIme;

    @FXML
    private TableColumn<Racun, Double> tcDuguje;

    @FXML
    private TableColumn<Racun, Double> tcPotrazuje;

    @FXML
    private TableColumn<Racun, String> tcAP;

    @FXML
    private TableView<Konto> tvKonto;

    @FXML
    private ComboBox cbAP;


    @FXML
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("A");
        list.add("P");
        list.add("R");
        cbAP.setItems(list);
        tcId.setCellValueFactory(new PropertyValueFactory("id"));
        tcSifra.setCellValueFactory(new PropertyValueFactory("sifra"));
        tcIme.setCellValueFactory(new PropertyValueFactory("ime"));
        tcDuguje.setCellValueFactory(new PropertyValueFactory("duguje"));
        tcPotrazuje.setCellValueFactory(new PropertyValueFactory("potrazuje"));
        tcAP.setCellValueFactory(new PropertyValueFactory("a_p_r_p"));

        //System.out.println("USO JE Ovde Scene BilderFaktura");
        try {
            ucitajKonte();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void nalog(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/nalog.fxml");
    }

    public void addKonto(ActionEvent actionEvent) throws IOException {
//        changeContent("racunovodja/addKonto.fxml");
    }


    public void izmeniKonto(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniKonto.fxml");
    }

    public void filterKonto(ActionEvent actionEvent) throws SQLException {
        String selected = (String)cbAP.getValue();
        ObservableList<Konto> list = FXCollections.observableArrayList();

        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;
        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            //System.out.println("prosoAddKlijent");
            Statement stmt = myConn.createStatement();
            String sql = "select * from konto WHERE A_P_R_P = '" + selected + "'";
            System.out.println(sql);
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();

            while(myRS.next()){
                //System.out.println("KLIJENT");

                int id = myRS.getInt("idKonto");
                String sifra = myRS.getString("sifra");
                String ime = myRS.getString("ime");
                double duguje = myRS.getDouble("duguje");
                double potrazuje = myRS.getDouble("potrazuje");
                String a_p_r_p = myRS.getString("A_P_R_P");

                Konto konto = new Konto(id,sifra,ime,duguje,potrazuje,a_p_r_p);
                System.out.println(konto.getId());
                list.add(konto);
                tvKonto.setItems(list);
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
    public void ucitajKonte() throws SQLException {
        ObservableList<Konto> list = FXCollections.observableArrayList();
        String dbURL = "jdbc:mysql://localhost:3306/mydb";

        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("prosaoKlijent");
            String sql = "select * from konto";
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();

            while(myRS.next()){
                //System.out.println("KLIJENT");

                int id = myRS.getInt("idKonto");
                String sifra = myRS.getString("sifra");
                String ime = myRS.getString("ime");
                double duguje = myRS.getDouble("duguje");
                double potrazuje = myRS.getDouble("potrazuje");
                String a_p_r_p = myRS.getString("A_P_R_P");

                Konto konto = new Konto(id,sifra,ime,duguje,potrazuje,a_p_r_p);
                System.out.println(konto.getId());
                list.add(konto);
                tvKonto.setItems(list);
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
        idKontoPane.getChildren().removeAll();
        idKontoPane.getChildren().addAll((root));
    }
}
