package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class IzmeniFakturuRacunovodjaController {



    @FXML
    private Pane idIzmeniFakturuRacunovodjaPane;

    @FXML
    private Button btDodajArtikal;

    @FXML
    private Button btDodajKupca;

    @FXML
    private Button btDodajDobavljaca;

    @FXML
    private Button btSaveFaktura;

    @FXML
    private Button btIzmeniPdv;


    public void addArtikal(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniArtikalRacunovodja.fxml");
    }

    public void addKupac(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniKupacRacunovodja.fxml");
    }

    public void addDobavljac(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniDobavljacRacunovodja.fxml");
    }

    public void saveFaktura(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/fakturaRacunovodja.fxml");
    }
    public void izmeniPdv(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniPdvRacunovodja.fxml");
    }


    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idIzmeniFakturuRacunovodjaPane.getChildren().removeAll();
        idIzmeniFakturuRacunovodjaPane.getChildren().addAll((root));
    }


}
