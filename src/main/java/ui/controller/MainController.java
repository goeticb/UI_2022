package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import ui.ui2021.App;

import java.io.IOException;

public class MainController {

    @FXML
    private Button btDashboard;
    @FXML
    private Button btCallingData;
    @FXML
    private Button btComplains;
    @FXML
    private Button btAccounts;
    @FXML
    private StackPane contentArea;

    public void dashboard(ActionEvent event) throws IOException {
        changeContent("dashboard.fxml");
    }

    public void callingData(ActionEvent event) throws IOException {
        changeContent("callingData.fxml");
    }

    public void complains(ActionEvent event) throws IOException {
        changeContent("complains.fxml");
    }

    public void accounts(ActionEvent event) throws IOException {
        changeContent("accounts.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        contentArea.getChildren().removeAll();
        contentArea.getChildren().addAll((root));
    }
}
