package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class ZaposleniController {


    @FXML
    private Pane idZaposneliPaneRacunovodja;

    @FXML
    private Button btTipRacunovodja;
    @FXML
    private Button btProjekatRacunovodja;

    @FXML
    private Button btAddZaposleni;

    @FXML
    private Button btIzmeniZaposleni;

    @FXML
    private Button btDeleteZaposleni;




    public void tip(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/tip.fxml");
    }

    public void projekat(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/projekat.fxml");
    }
    public void addZaposleni(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addZaposleni.fxml");
    }

    public void deleteZaposleni(ActionEvent actionEvent) {
    }

    public void izmeniZaposleni(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniZaposleni.fxml");
    }

    public void logOut(ActionEvent actionEvent) throws IOException {
        App.getInstance().changeScene("login.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idZaposneliPaneRacunovodja.getChildren().removeAll();
        idZaposneliPaneRacunovodja.getChildren().addAll((root));
    }



}
