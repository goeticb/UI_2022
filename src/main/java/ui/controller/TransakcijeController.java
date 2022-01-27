package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class TransakcijeController {
    @FXML
    private Button btBeleznik;
    @FXML
    private Pane idPane;

    public void beleznik(ActionEvent event) throws IOException {
        changeContent("klijent/beleznik.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idPane.getChildren().removeAll();
        idPane.getChildren().addAll((root));
    }
}
