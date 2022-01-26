package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import ui.ui2021.App;

import java.io.IOException;

public class RacunovodjaController {


    @FXML
    private Button idDash;
    @FXML
    private Button idAccount;
    @FXML
    private Button idLogOut;
    @FXML
    private StackPane area;

    public void DashAction(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/Dash.fxml");
        //App.getInstance().changeScene("racunovodja/Dash.fxml");
    }

    public void LogOutAction(ActionEvent actionEvent) throws IOException {
        App.getInstance().changeScene("login.fxml");
    }
    public void AccountAction(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/Account.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        area.getChildren().removeAll();
        area.getChildren().addAll((root));
    }


    public void Izvestaji(ActionEvent actionEvent) {
    }
}
