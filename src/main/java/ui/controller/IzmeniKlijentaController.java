package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class IzmeniKlijentaController {

    @FXML
    private Pane idIzmeniKlijentaPane;

    public void saveKlijent(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/klijenti.fxml");
    }
    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idIzmeniKlijentaPane.getChildren().removeAll();
        idIzmeniKlijentaPane.getChildren().addAll((root));
    }
}
