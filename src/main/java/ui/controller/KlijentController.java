package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import ui.ui2021.App;

import java.io.IOException;

public class KlijentController {

    @FXML
    private Button btDashboard;
    @FXML
    private Button btCallingData;
    @FXML
    private Button btComplains;
    @FXML
    private Button btAccounts;
    @FXML
    private StackPane contentArea;

    public void transkacije(ActionEvent event) throws IOException {
        changeContent("klijent/transakcije.fxml");
    }

    public void faktura(ActionEvent event) throws IOException {
        changeContent("klijent/fakture.fxml");
    }

    public void zaposleni(ActionEvent event) throws IOException {
        changeContent("klijent/zaposleni.fxml");
    }

    public void racun(ActionEvent event) throws IOException {
        changeContent("klijent/racun.fxml");
    }

    public void logOut(ActionEvent event) throws IOException {
        App.getInstance().changeScene("login.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        contentArea.getChildren().removeAll();
        contentArea.getChildren().addAll((root));
    }
}
