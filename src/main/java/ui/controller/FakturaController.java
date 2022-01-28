package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class FakturaController {

    @FXML
    private Pane idFakturaPane;

    @FXML
    private Button btAddFaktura;

    @FXML
    private Button btIzmeniFakturu;

    @FXML
    private Button btDeleteFaktura;

    public void addFaktura(ActionEvent actionEvent) throws IOException {
        changeContent("klijent/addFaktura.fxml");
    }

    public void izmeniFakturu(ActionEvent actionEvent) throws IOException {
        changeContent("klijent/izmeniFakturu.fxml");
    }

    public void deleteFaktura(ActionEvent actionEvent) throws IOException {

    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idFakturaPane.getChildren().removeAll();
        idFakturaPane.getChildren().addAll((root));
    }

}
