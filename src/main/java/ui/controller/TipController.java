package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class TipController {


    @FXML
    private Pane tipPaneRacunovodja;

    @FXML
    private Button btAddTip;

    @FXML
    private Button btIzmeniTip;

    @FXML
    private Button btDeleteTip;


    public void addTip(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addTip.fxml");
    }

    public void izmeniTip(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniTip.fxml");
    }

    public void deleteTip(ActionEvent actionEvent) {

    }


    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        tipPaneRacunovodja.getChildren().removeAll();
        tipPaneRacunovodja.getChildren().addAll((root));
    }


}
