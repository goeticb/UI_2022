package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class AddKupacController {

    @FXML
    private Pane idAddKupacPane;

    @FXML
    private Button btSaveKupac;

    public void saveKupac(ActionEvent actionEvent) throws IOException {
        changeContent("klijent/addFaktura.fxml");
    }
    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idAddKupacPane.getChildren().removeAll();
        idAddKupacPane.getChildren().addAll((root));
    }
}
