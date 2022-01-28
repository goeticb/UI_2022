package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.awt.*;
import java.io.IOException;

public class FakturaRacunovodjaController {

    @FXML
    private Pane idFakturaRacunovodjaPane;

    @FXML
    private Button btAddFaktura;

    @FXML
    private Button btIzmeniFakturu;

    @FXML
    private Button btDeleteFaktura;


    public void addFaktura(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addFakturaRacunovodja.fxml");
    }

    public void izmeniFakturu(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniFakturuRacunovodja.fxml");
    }

    public void deleteFaktura(ActionEvent actionEvent) {
    }


    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idFakturaRacunovodjaPane.getChildren().removeAll();
        idFakturaRacunovodjaPane.getChildren().addAll((root));
    }
}
