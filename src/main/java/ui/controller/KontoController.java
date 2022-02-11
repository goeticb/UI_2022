package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class KontoController {

    @FXML
    private Pane idKontoPane;

    public void nalog(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/nalog.fxml");
    }

    public void addKonto(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addKonto.fxml");
    }

    public void deleteKonto(ActionEvent actionEvent) {
    }

    public void izmeniKonto(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniKonto.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idKontoPane.getChildren().removeAll();
        idKontoPane.getChildren().addAll((root));
    }
}
