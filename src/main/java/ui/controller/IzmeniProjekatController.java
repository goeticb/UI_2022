package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class IzmeniProjekatController {

    @FXML
    private Pane idIzmeniProjekatPane;


    @FXML
    private Button btSaveProjekat;



    public void saveProjekat(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/projekatRacunovodja.fxml");
    }
    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idIzmeniProjekatPane.getChildren().removeAll();
        idIzmeniProjekatPane.getChildren().addAll((root));
    }

}
