package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class IzmeniRacunController {


    @FXML
    private Pane idIzmeniRacunPane;


    @FXML
    private Button btSaveRacun;


    public void saveRacun(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/racun.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idIzmeniRacunPane.getChildren().removeAll();
        idIzmeniRacunPane.getChildren().addAll((root));
    }


}
