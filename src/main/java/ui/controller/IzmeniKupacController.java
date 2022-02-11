package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class IzmeniKupacController {

    @FXML
    private Pane idIzmeniKupacRacunovodjaPane;

    @FXML
    private Button btSaveKupac;

    public void saveKupac(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniFakturu.fxml");
    }
    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idIzmeniKupacRacunovodjaPane.getChildren().removeAll();
        idIzmeniKupacRacunovodjaPane.getChildren().addAll((root));
    }
}
