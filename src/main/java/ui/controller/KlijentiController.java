package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.sql.*;

import java.io.IOException;
import java.sql.SQLException;

public class KlijentiController {

    @FXML
    private Pane idKlijentiPane;

    @FXML
    private TreeTableView ttvKlijenti;

    @FXML
    public void initialize() {

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

    public void deleteKlijent(ActionEvent actionEvent) throws IOException {

    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idKlijentiPane.getChildren().removeAll();
        idKlijentiPane.getChildren().addAll((root));
    }
    private void ucitajKlijente() throws SQLException {

        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;

        try {
            myConn = DriverManager.getConnection(dbURL, user, pass);
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
                //ttvKlijenti.get

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
