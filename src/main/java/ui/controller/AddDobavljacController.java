package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class AddDobavljacController {
    @FXML
    private Pane idAddDobavljacRacunovodjaPane;
    @FXML
    private Button btSaveDobavljac;

    public void saveDobavljac(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addFaktura.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idAddDobavljacRacunovodjaPane.getChildren().removeAll();
        idAddDobavljacRacunovodjaPane.getChildren().addAll((root));
    }


}
