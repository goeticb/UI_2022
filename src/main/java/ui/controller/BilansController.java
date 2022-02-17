package ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.model.Klijent;
import ui.ui2021.App;

import java.sql.*;

public class BilansController {
    @FXML
    private Label lbl0;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private Label lbl5;

    @FXML
    private Label lbl6;

    @FXML
    public void initialize() {
        System.out.println("USO JE Bilans");
        try {
            ucitajBilanse();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void ucitajBilanse() throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/mydb";


        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;

        int l0 = 0;
        int l1 = 0;
        int l2 = 0;
        int l3 = 0;
        int l4 = 0;
        int l5 = 0;
        int l6 = 0;


        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());

            String sql = "select * from konto";
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();

            while (myRS.next()) {
                //System.out.println("KLIJENT");

                int sifra = myRS.getInt("sifra");
                int sum = myRS.getInt("potrazuje");
                while(sifra >= 10){
                    sifra = sifra/10;
                }
                if(sifra == 0){
                    l0 = l0 + sum;
                    continue;
                }
                if(sifra == 1){
                    l1 = l1 + sum;
                    continue;
                }
                if(sifra == 2){
                    l2 = l2 + sum;
                    continue;
                }
                if(sifra == 3){
                    l3 = l3 + sum;
                    continue;
                }
                if(sifra == 4){
                    l4 = l4 + sum;
                    continue;
                }
                if(sifra == 5){
                    l5 = l5 + sum;
                    continue;
                }
                if(sifra == 0){
                    l6 = l6 + sum;
                    continue;
                }
            }
            lbl0.setText(String.valueOf(l0));
            lbl1.setText(String.valueOf(l1));
            lbl2.setText(String.valueOf(l2));
            lbl3.setText(String.valueOf(l3));
            lbl4.setText(String.valueOf(l4));
            lbl5.setText(String.valueOf(l5));
            lbl6.setText(String.valueOf(l6));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (myConn != null) {
                myConn.close();
            }
            if (myRS != null) {
                myRS.close();
            }
        }
    }
}
