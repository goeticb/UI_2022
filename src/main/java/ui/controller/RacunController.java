package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class RacunController {


    @FXML
    private Pane idRacunRacunovodja;

    @FXML
    private Button btPozajmicaRacunovodja;

    @FXML
    private Button btAddRacun;
    @FXML
    private  Button btIzmeniRacun;
    @FXML
    private Button btDeleteRacun;

    public void pozajmica(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/pozajmica.fxml");
    }
    public void addRacun(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addRacun.fxml");
    }

    public void izmeniRacun(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniRacun.fxml");
    }

    public void deleteRacun(ActionEvent actionEvent) {
    }
    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idRacunRacunovodja.getChildren().removeAll();
        idRacunRacunovodja.getChildren().addAll((root));
    }



}
