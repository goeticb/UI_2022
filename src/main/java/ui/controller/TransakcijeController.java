package ui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import ui.model.Klijent;
import ui.model.Transakcija;
import ui.ui2021.App;

import java.io.IOException;
import java.sql.*;

public class TransakcijeController {

    @FXML
    private TableColumn<Transakcija, Date> tcDate;

    @FXML
    private TableColumn<Transakcija, Integer> tcFakturaId;

    @FXML
    private TableColumn<Transakcija, Integer> tcId;

    @FXML
    private TableColumn<Transakcija, Integer> tcSuma;

    @FXML
    private TableColumn<Transakcija, String> tcTipTransakcije;

    @FXML
    private TableColumn<Transakcija, String> tcUplatilac;

    @FXML
    private TableView<Transakcija> tvTransakcija;
    @FXML
    private Button btBeleznikRacunovodja;
    @FXML
    private Pane idTransakcijeRacunovodjaPane;
    @FXML
    public void initialize() {
        tcId.setCellValueFactory(new PropertyValueFactory("id"));
        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
        tcUplatilac.setCellValueFactory(new PropertyValueFactory("uplatilac"));
        tcFakturaId.setCellValueFactory(new PropertyValueFactory("fakturaId"));
        tcTipTransakcije.setCellValueFactory(new PropertyValueFactory("tipTransakcije"));
        tcSuma.setCellValueFactory(new PropertyValueFactory("suma"));
        try {
            ucitajTransakcije();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idTransakcijeRacunovodjaPane.getChildren().removeAll();
        idTransakcijeRacunovodjaPane.getChildren().addAll((root));
    }
    private void ucitajTransakcije() throws SQLException {
        ObservableList<Transakcija> list = FXCollections.observableArrayList();
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("prosoTransakcija");
            String sql = "select * from transakcija";
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();

            while(myRS.next()){
                //System.out.println("KLIJENT");

                int id = myRS.getInt("idTransakcija");
                Date date = myRS.getDate("datum");
                System.out.println(date);
                int suma = myRS.getInt("suma");
                String tipTransakcije = myRS.getString("tipTransakcije");
                String uplatilac = myRS.getString("upatilac");
                int fakturaId = myRS.getInt("Faktura_idFaktura");

                Transakcija transakcija = new Transakcija(id, date, suma, tipTransakcije, uplatilac, fakturaId);
                list.add(transakcija);
                tvTransakcija.setItems(list);
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
