package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class AddPozajmicaController {

    @FXML
    private Pane idPozajmicaPane;

    @FXML
    private TextField tfPrincipal;

    @FXML
    private TextField tfInterest;

    @FXML
    private DatePicker dpDatum;

    @FXML
    private TextArea taOpis;

    @FXML
    private Button btSavePozajmica;

    public void savePozajmica(ActionEvent actionEvent) throws IOException, SQLException {
        ZoneId defaultZoneId = ZoneId.systemDefault();

        String principalText = tfPrincipal.getText();
        String interestText = tfInterest.getText();
        LocalDate datumDate = dpDatum.getValue();
        Date date = Date.from(datumDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
        String opisText = taOpis.getText();

        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("AddPozajmica");
            Statement stmt = myConn.createStatement();
            String sql = "INSERT INTO pozajmica (principal, interest, datum, opis) VALUES ('"+ principalText +"', '"+ interestText +"', '"+datumDate +"', '"+ opisText + "')";
            System.out.println(sql);
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(myConn != null){
                myConn.close();
            }
        }
        changeContent("racunovodja/pozajmica.fxml");
    }


    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idPozajmicaPane.getChildren().removeAll();
        idPozajmicaPane.getChildren().addAll((root));
    }
}
