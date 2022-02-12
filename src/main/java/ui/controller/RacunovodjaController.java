package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import ui.ui2021.App;

import java.io.IOException;

public class RacunovodjaController {

    @FXML
    public Button btZaposleniRacunovodja;
    @FXML
    public Button btRacun;
    @FXML
    private StackPane contentAreaRacunovodja;
    @FXML
    private Button btTranskacije;
    @FXML
    private Button btFaktura;


    public void transkacije(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/transakcije.fxml");
    }

    public void faktura(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/faktura.fxml");

    }

    public void zaposleniRacunovodja(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/zaposleni.fxml");
    }

    public void racun(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/racun.fxml");
    }

    public void klijenti(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/klijenti.fxml");
    }

    public void konto(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/konto.fxml");
    }

    public void logOut(ActionEvent actionEvent) throws IOException {
        App.getInstance().changeScene("login.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        contentAreaRacunovodja.getChildren().removeAll();
        contentAreaRacunovodja.getChildren().addAll((root));
    }

}
