package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddArtikalController {

    @FXML
    private Pane idAddArtikalRacunovodjaPane;

    @FXML
    private Button btSaveArtikal;

    @FXML
    private TextField tfNazivStavke;

    @FXML
    private TextField tfCena;

    @FXML
    private TextField tfJm;

    @FXML
    public void initialize() {
        //System.out.println("USO JE Ovde Scene BilderArtikal");
    }

    public void saveArtikal(ActionEvent actionEvent) throws IOException, SQLException {

        String nazivStavke = tfNazivStavke.getText();
        int cena = Integer.parseInt(tfCena.getText());
        String jm = tfJm.getText();
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("prosoAddKlijent");
            Statement stmt = myConn.createStatement();
            String sql = "INSERT INTO stavka (nazivStavke, cena, jm) VALUES ('"+ nazivStavke +"', "+ cena +", '"+jm + "')";
            System.out.println(sql);
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(myConn != null){
                myConn.close();
            }
        }
        changeContent("racunovodja/addFaktura.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idAddArtikalRacunovodjaPane.getChildren().removeAll();
        idAddArtikalRacunovodjaPane.getChildren().addAll((root));
    }
}
