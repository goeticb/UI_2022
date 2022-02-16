package ui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
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
    private DatePicker dpOd;
    @FXML
    private DatePicker dpDo;
    @FXML
    private Button btPretrazi;

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
        tcFakturaId.setCellValueFactory(new PropertyValueFactory("fakturaId"));
        tcTipTransakcije.setCellValueFactory(new PropertyValueFactory("tipTransakcije"));
        tcSuma.setCellValueFactory(new PropertyValueFactory("suma"));
        try {
            ucitajTransakcije();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchTransakcije(ActionEvent actionEvent) throws IOException, SQLException {

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

            String from = "", to = "";
            int flag = 0;
            if(dpOd.getValue().toString() != ""){
                flag ++;
                from = " datum >= \""+dpOd.getValue().toString() +"\"";
            }
            if(dpDo.getValue().toString() != ""){
                flag ++;
                to = " datum <= \""+ dpDo.getValue().toString() +"\"";
            }

            String sql = "select * from transakcija";

            if(flag == 1){
                if(dpOd.getValue().toString() != "")
                    sql = "select * from transakcija where " + from;
                else
                    sql = "select * from transakcija where " + to;
            }else if(flag ==2)
                sql = "select * from transakcija where " + from + " and " +to;


            System.out.println(from);
            System.out.println(to);
            System.out.println(dpDo.getValue().toString());
            System.out.println(dpOd.getValue().toString());
            System.out.println(sql);
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();
            int c = 0;

            while(myRS.next()){
                c=1;

                System.out.println("KLIJENT");

                int id = myRS.getInt("idTransakcija");
                Date date = myRS.getDate("datum");
                System.out.println(date);
                int suma = myRS.getInt("suma");
                String tipTransakcije = myRS.getString("tipTransakcije");
                int fakturaId = myRS.getInt("Faktura_idFaktura");

                Transakcija transakcija = new Transakcija(id, date, suma, tipTransakcije, fakturaId);
                list.add(transakcija);
                tvTransakcija.setItems(list);
                System.out.println(list);
            }
            if(c==0) tvTransakcija.setItems(null);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(myConn != null){
                try {
                    myConn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(myRS != null){
                try {
                    myRS.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
                int fakturaId = myRS.getInt("Faktura_idFaktura");

                Transakcija transakcija = new Transakcija(id, date, suma, tipTransakcije, fakturaId);
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
