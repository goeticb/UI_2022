package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import ui.ui2021.App;
import java.sql.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddKlijentController {

    @FXML
    private Pane idAddKlijentPane;

    @FXML
    private TextField tfNazivKlijenta;

    @FXML
    private TextField tfAdresa;

    @FXML
    private TextField tfRacun;

    public void saveKlijent(ActionEvent actionEvent) throws IOException, SQLException {
        String nazivKlijenta = tfNazivKlijenta.getText();
        String adresa = tfAdresa.getText();
        int racun = Integer.parseInt(tfRacun.getText());
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("prosoAddKlijent");
            Statement stmt = myConn.createStatement();
            String sql = "INSERT INTO klijent (nazivKlijenta, adresaKlijenta, racunKlijenta) VALUES ('"+ nazivKlijenta +"', '"+ adresa +"', "+racun + ")";
            System.out.println(sql);
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(myConn != null){
                myConn.close();
            }
        }
        changeContent("racunovodja/klijenti.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idAddKlijentPane.getChildren().removeAll();
        idAddKlijentPane.getChildren().addAll((root));
    }
}
