package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class ProjekatController {


    @FXML
    private Pane idProjekatPane;

    @FXML
    private Button btAddProjekat;

    @FXML
    private Button btIzmeniProjekat;

    @FXML
    private Button btDeleteProjekat;


    public void addProjekat(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addProjekat.fxml");
    }

    public void izmeniProjekat(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniProjekat.fxml");
    }

    public void deleteProjekat(ActionEvent actionEvent) {
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idProjekatPane.getChildren().removeAll();
        idProjekatPane.getChildren().addAll((root));
    }


}
