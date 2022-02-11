package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class KlijentiController {

    @FXML
    private Pane idKlijentiPane;

    public void addKlijent(ActionEvent actionEvent) throws IOException{
        changeContent("racunovodja/addKlijent.fxml");
    }

    public void izmeniKlijenta(ActionEvent actionEvent) throws IOException{
        changeContent("racunovodja/izmeniKlijenta.fxml");
    }

    public void deleteKlijent(ActionEvent actionEvent) throws IOException {

    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idKlijentiPane.getChildren().removeAll();
        idKlijentiPane.getChildren().addAll((root));
    }
}
