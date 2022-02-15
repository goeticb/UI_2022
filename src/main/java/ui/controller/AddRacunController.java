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

public class AddRacunController {

    @FXML
    private Pane idAddRacunPane;


    @FXML
    private Button btSaveRacun;

    @FXML
    private TextField tfBrojRacuna;

    @FXML
    private TextField tfImeBanke;

    public void saveRacun(ActionEvent actionEvent) throws IOException, SQLException {

        int brojRacuna = Integer.parseInt(tfBrojRacuna.getText());
        String imeBanke = tfImeBanke.getText();

        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("prosoAddKlijent");
            Statement stmt = myConn.createStatement();
            String sql = "INSERT INTO racunUBanci (brojRacuna, imeBanke) VALUES ("+ brojRacuna +", '"+ imeBanke + "')";
            System.out.println(sql);
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(myConn != null){
                myConn.close();
            }
        }

        changeContent("racunovodja/racun.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idAddRacunPane.getChildren().removeAll();
        idAddRacunPane.getChildren().addAll((root));
    }

}
