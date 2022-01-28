package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class AddFakturaRacunovodjaController {

    @FXML
    private Pane idAddFakturaRacunovodjaPane;

    @FXML
    private Button btDodajKupca;

    @FXML
    private Button btDodajDobavljaca;

    @FXML
    private Button btSaveFaktura;

    @FXML
    private Button btDodajArtikal;

    @FXML
    private Button btDodajPdv;

    public void addArtikal(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addArtikalracunovodja.fxml");
    }

    public void addKupac(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addKupacRacunovodja.fxml");
    }

    public void addDobavljac(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addDobavljacRacunovodja.fxml");
    }

    public void saveFaktura(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/fakturaRacunovodja.fxml");
    }
    public void addPdv(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addPdvRacunovodja.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idAddFakturaRacunovodjaPane.getChildren().removeAll();
        idAddFakturaRacunovodjaPane.getChildren().addAll((root));
    }


}
