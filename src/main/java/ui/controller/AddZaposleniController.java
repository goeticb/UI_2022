package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class AddZaposleniController {

    @FXML
    private Pane idAddZaposleniPane;


    @FXML
    private Button btSaveZaposleni;


    public void saveZaposleni(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/zaposleni.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idAddZaposleniPane.getChildren().removeAll();
        idAddZaposleniPane.getChildren().addAll((root));
    }

}
