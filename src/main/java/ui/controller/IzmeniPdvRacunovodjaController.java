package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class IzmeniPdvRacunovodjaController {

    @FXML
    private Pane idIzmeniPdvRacunovodjaPane;

    @FXML
    private Button btSaveArtikal;

    public void saveArtikal(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniFakturuRacunovodja.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idIzmeniPdvRacunovodjaPane.getChildren().removeAll();
        idIzmeniPdvRacunovodjaPane.getChildren().addAll((root));
    }
}
