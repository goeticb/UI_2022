package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;

public class AddTipController {




    @FXML
    private Pane idAddTipPane;


    @FXML
    private Button btSaveTip;






    public void saveTip(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/tip.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idAddTipPane.getChildren().removeAll();
        idAddTipPane.getChildren().addAll((root));
    }

}
