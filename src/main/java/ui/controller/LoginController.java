package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ui.ui2021.App;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button button;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;


    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        if (username.getText().equals("klijent") && password.getText().equals("123")) {
            App.getInstance().changeScene("main.fxml");
        }if (username.getText().equals("racunovodja") && password.getText().equals("123")) {
            App.getInstance().changeScene("racunovodja.fxml");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogIn.setText("Please enter your data.");
        } else {
            wrongLogIn.setText("Wrong username or password!");
        }
    }
}