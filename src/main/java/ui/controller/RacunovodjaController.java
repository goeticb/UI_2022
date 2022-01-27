package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import ui.ui2021.App;

import java.io.IOException;

public class RacunovodjaController {


    public Button btZaposleniRacunovodja;
    @FXML
    private StackPane contentAreaRacunovodja;

    public Button btRacun;
    @FXML
    private Button btTranskacije;





    public void transkacije(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/transakcijeRacunovodja.fxml");
    }

    public void faktura(ActionEvent actionEvent) {

    }

    public void zaposleniRacunovodja(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/zaposleniRacunovodja.fxml");
    }

    public void racun(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/racunRacunovodja.fxml");
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
