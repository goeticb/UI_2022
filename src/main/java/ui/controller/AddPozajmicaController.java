package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class AddPozajmicaController {

    @FXML
    private Pane idPozajmicaPane;

    @FXML
    private Button btSavePozajmica;

    public void savePozajmica(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/pozajmicaRacunovodja.fxml");
    }



    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idPozajmicaPane.getChildren().removeAll();
        idPozajmicaPane.getChildren().addAll((root));
    }
}
