package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import ui.ui2021.App;

import java.io.IOException;
import java.sql.*;

public class AddKontoController {

    @FXML
    private Pane idAddKontoPane;
    @FXML
    private Button btSaveKonto;

    @FXML
    private TextField tfAPRP;

    @FXML
    private TextField tfIme;

    @FXML
    private TextField tfSifra;



    public void saveKonto(ActionEvent actionEvent) throws IOException, SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "root";

        Connection myConn = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("prosoAddKonto");
            Statement stmt = myConn.createStatement();
            String sql = "SELECT * FROM nalog";
            stmt = myConn.createStatement();
            ResultSet myRS = stmt.executeQuery(sql);
            int nalogId = 0;
            while (myRS.next()) {
                int temp = myRS.getInt("idNalog");
                System.out.println("NALOG" + temp);
                nalogId = temp;
            }
             sql = "SELECT * FROM transakcija";
            stmt = myConn.createStatement();
             myRS = stmt.executeQuery(sql);
            String tipTransakcije = "";
            int suma=0;
            while (myRS.next()) {
                String temp = myRS.getString("tipTransakcije");
                tipTransakcije = temp;
                int temp2 = myRS.getInt("suma");
                suma=temp2;

            }
            sql = "SELECT * FROM faktura";
            stmt = myConn.createStatement();
            myRS = stmt.executeQuery(sql);
            int klijentid = 0;
            while (myRS.next()) {
                int temp2 = myRS.getInt("Klijent_idKlijent");
                klijentid=temp2;
            }
            String x="";
            if(tipTransakcije.equals("Uplata"))
                x="potrazuje";
            else
                x="duguje";

            if(tfSifra.getText().length()==3){
                System.out.println("uslo ovde za konto = 3");
                    sql = "INSERT INTO konto (sifra, ime, A_P_R_P,"+x+") VALUES" + "(" + tfSifra.getText().charAt(0) + ",'" + tfIme.getText() + "'" + ",'" + tfAPRP.getText() + "'," + suma + ")";
                    System.out.println("prvi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);
                    sql = "SELECT * FROM konto";
                    stmt = myConn.createStatement();
                    myRS = stmt.executeQuery(sql);
                    int id = 0;
                    while (myRS.next()) {
                        int temp2 = myRS.getInt("idKonto");
                        id=temp2;

                    }
                    sql = "INSERT INTO konto_has_nalog (Konto_idKonto,Nalog_idNalog) VALUES" + "(" + id + "," + nalogId +")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO sintetickikonto (Konto_idKonto) VALUES" + "(" + id + ")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO analitickikonto (Konto_idKonto,Klijent_idDobavljac) VALUES" + "(" + id +","+klijentid+ ")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO konto (sifra, ime, A_P_R_P,"+x+",Roditelj_FK) VALUES" + "(" + tfSifra.getText().charAt(0)+tfSifra.getText().charAt(1) + ",'" + tfIme.getText() + "'" + ",'" + tfAPRP.getText() + "'," + suma + ","+id+")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "SELECT * FROM konto";
                    stmt = myConn.createStatement();
                    myRS = stmt.executeQuery(sql);
                    id = 0;
                    while (myRS.next()) {
                        int temp2 = myRS.getInt("idKonto");
                        id=temp2;

                    }
                    sql = "INSERT INTO konto_has_nalog (Konto_idKonto,Nalog_idNalog) VALUES" + "(" + id + "," + nalogId +")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO sintetickikonto (Konto_idKonto) VALUES" + "(" + id + ")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO analitickikonto (Konto_idKonto,Klijent_idDobavljac) VALUES" + "(" + id +","+klijentid+ ")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO konto (sifra, ime, A_P_R_P,"+x+",Roditelj_FK) VALUES" + "(" + tfSifra.getText() + ",'" + tfIme.getText() + "'" + ",'" + tfAPRP.getText() + "'," + suma + ","+id+")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "SELECT * FROM konto";
                    stmt = myConn.createStatement();
                    myRS = stmt.executeQuery(sql);
                    id = 0;
                    while (myRS.next()) {
                        int temp2 = myRS.getInt("idKonto");
                        id=temp2;

                    }
                    sql = "INSERT INTO konto_has_nalog (Konto_idKonto,Nalog_idNalog) VALUES" + "(" + id + "," + nalogId +")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO sintetickikonto (Konto_idKonto) VALUES" + "(" + id + ")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO analitickikonto (Konto_idKonto,Klijent_idDobavljac) VALUES" + "(" + id +","+klijentid+ ")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);


            }
            if(tfSifra.getText().length()==2){
                    sql = "INSERT INTO konto (sifra, ime, A_P_R_P,"+x+") VALUES" + "(" + tfSifra.getText().charAt(0) + ",'" + tfIme.getText() + "'" + ",'" + tfAPRP.getText() + "'," + suma + ")";
                    System.out.println("prvi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);
                    sql = "SELECT * FROM konto";
                    stmt = myConn.createStatement();
                    myRS = stmt.executeQuery(sql);
                    int id = 0;
                    while (myRS.next()) {
                        int temp2 = myRS.getInt("idKonto");
                        id=temp2;

                    }
                    sql = "INSERT INTO konto_has_nalog (Konto_idKonto,Nalog_idNalog) VALUES" + "(" + id + "," + nalogId +")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO sintetickikonto (Konto_idKonto) VALUES" + "(" + id + ")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO analitickikonto (Konto_idKonto,Klijent_idDobavljac) VALUES" + "(" + id +","+klijentid+ ")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO konto (sifra, ime, A_P_R_P,"+x+",Roditelj_FK) VALUES" + "(" + tfSifra.getText() + ",'" + tfIme.getText() + "'" + ",'" + tfAPRP.getText() + "'," + suma + ","+id+")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "SELECT * FROM konto";
                    stmt = myConn.createStatement();
                    myRS = stmt.executeQuery(sql);
                    id = 0;
                    while (myRS.next()) {
                        int temp2 = myRS.getInt("idKonto");
                        id=temp2;

                    }
                    sql = "INSERT INTO konto_has_nalog (Konto_idKonto,Nalog_idNalog) VALUES" + "(" + id + "," + nalogId +")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO sintetickikonto (Konto_idKonto) VALUES" + "(" + id + ")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);

                    sql = "INSERT INTO analitickikonto (Konto_idKonto,Klijent_idDobavljac) VALUES" + "(" + id +","+klijentid+ ")";
                    System.out.println("drugi");
                    System.out.println(sql);
                    stmt.executeUpdate(sql);




            }
            if(tfSifra.getText().length()==1){
                //String sql = "INSERT INTO stavka (nazivStavke, cena, jm) VALUES ('"+ nazivStavke +"', "+ cena +", '"+jm + "')";
                if(tipTransakcije.equals("Uplata"))
                    sql = "INSERT INTO konto (sifra, ime, A_P_R_P,potrazuje) VALUES"+"("+tfSifra.getText()+",'"+tfIme.getText()+"'"+",'"+tfAPRP.getText()+"',"+suma+")";
                if(tipTransakcije.equals("Isplata"))
                    sql = "INSERT INTO konto (sifra, ime, A_P_R_P,duguje) VALUES"+"("+tfSifra.getText()+",'"+tfIme.getText()+"'"+",'"+tfAPRP.getText()+"',"+suma+")";

                //System.out.println(sql);
                stmt.executeUpdate(sql);
                sql = "SELECT * FROM konto";
                stmt = myConn.createStatement();
                myRS = stmt.executeQuery(sql);
                int id = 0;
                while (myRS.next()) {
                    int temp2 = myRS.getInt("idKonto");
                    id=temp2;

                }
                sql = "INSERT INTO konto_has_nalog (Konto_idKonto,Nalog_idNalog) VALUES" + "(" + id + "," + nalogId +")";
                System.out.println("drugi");
                System.out.println(sql);
                stmt.executeUpdate(sql);

                sql = "INSERT INTO sintetickikonto (Konto_idKonto) VALUES" + "(" + id + ")";
                System.out.println("drugi");
                System.out.println(sql);
                stmt.executeUpdate(sql);

                sql = "INSERT INTO analitickikonto (Konto_idKonto,Klijent_idDobavljac) VALUES" + "(" + id +","+klijentid+ ")";
                System.out.println("drugi");
                System.out.println(sql);
                stmt.executeUpdate(sql);



            }




        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(myConn != null){
                myConn.close();
            }
        }






        changeContent("racunovodja/transakcije.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idAddKontoPane.getChildren().removeAll();
        idAddKontoPane.getChildren().addAll((root));
    }
}
