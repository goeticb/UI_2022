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
    private Pane idFakturaRacunovodjaPane;

    @FXML
    private Button btAddFaktura;

    @FXML
    private Button btIzmeniFakturu;

    @FXML
    private Button btDeleteFaktura;

    @FXML
    public void initialize() {
        System.out.println("USO JE Ovde Scene BilderFaktura");
    }

    public void addFaktura(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addFaktura.fxml");
        //App.getInstance().getMyConn();
    }

    public void izmeniFakturu(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniFakturu.fxml");
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
