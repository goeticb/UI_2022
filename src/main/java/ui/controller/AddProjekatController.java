package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class AddProjekatController {


    @FXML
    private Pane IdAddProjekatPane;

    @FXML
    private Button btSaveProjekat;



    public void saveProjekat(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/projekat.fxml");
    }
    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        IdAddProjekatPane.getChildren().removeAll();
        IdAddProjekatPane.getChildren().addAll((root));
    }

}
