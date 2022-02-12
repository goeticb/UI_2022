package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class PozajmicaController {


    @FXML
    private Pane idRacunRacunovodja;

    @FXML
    private Button btAddPozajmica;

    @FXML
    private Button btIzmeniPozajmica;

    @FXML
    private Button btDeletePozajmica;


    public void addPozajmica(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addPozajmica.fxml");
    }

    public void izmeniPozajmica(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniPozajmica.fxml");
    }

    public void deletePozajmica(ActionEvent actionEvent) {
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idRacunRacunovodja.getChildren().removeAll();
        idRacunRacunovodja.getChildren().addAll((root));
    }


}
