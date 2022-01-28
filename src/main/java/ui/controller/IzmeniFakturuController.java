package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class IzmeniFakturuController {

    @FXML
    private Pane idIzmeniFakturuPane;

    @FXML
    private Button btAddArtikal;

    @FXML
    private Button btAddKupac;

    @FXML
    private Button btAddDobavljac;

    public void addArtikal(ActionEvent actionEvent) throws IOException {
        changeContent("klijent/addArtikal.fxml");
    }

    public void addKupac(ActionEvent actionEvent) throws IOException {
        changeContent("klijent/addKupac.fxml");
    }

    public void addDobavljac(ActionEvent actionEvent) throws IOException {
        changeContent("klijent/addDobavljac.fxml");
    }

    public void saveFaktura(ActionEvent actionEvent) throws IOException {
        changeContent("klijent/faktura.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idIzmeniFakturuPane.getChildren().removeAll();
        idIzmeniFakturuPane.getChildren().addAll((root));
    }
}
