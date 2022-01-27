package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import ui.ui2021.App;

import java.io.IOException;

public class AccountsController {

    @FXML
    private Button btBack;

    @FXML
    private Pane idPane;

    @FXML
    private Button btTip;
    @FXML
    private Button btProjekat;





    public void back(ActionEvent actionEvent) throws IOException {
        changeContent("klijent/klijent.fxml");
    }
    public void tip(ActionEvent actionEvent) throws IOException {
        changeContent("klijent/tip.fxml");
    }

    public void projekat(ActionEvent actionEvent) throws IOException {
        changeContent("klijent/projekat.fxml");
    }


    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idPane.getChildren().removeAll();
        idPane.getChildren().addAll((root));
    }



}
