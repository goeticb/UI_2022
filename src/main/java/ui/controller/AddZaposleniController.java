package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import ui.model.Konto;
import ui.ui2021.App;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class AddZaposleniController {

    @FXML
    private Pane idAddZaposleniPane;

    @FXML
    private TextField tfIme;

    @FXML
    private TextField tfPrezime;

    @FXML
    private TextField tfJmbg;

    @FXML
    private DatePicker dpDatumRodjenja;

    @FXML
    private TextField tfKontakt;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfZvanje;

    @FXML
    private TextField tfRacunBanke;

    @FXML
    private TextField tfNazivBanke;

    @FXML
    private TextArea taOpis;

    @FXML
    private Button btSaveZaposleni;


    public void saveZaposleni(ActionEvent actionEvent) throws IOException, SQLException {

        String ime = tfIme.getText();
        String prezime = tfPrezime.getText();
        String jmbg = tfJmbg.getText();
        LocalDate datumRodjenja = dpDatumRodjenja.getValue();
        String kontakt = tfKontakt.getText();
        String email = tfEmail.getText();

        String brojRacuna = tfRacunBanke.getText();
        String nazivBanke = tfNazivBanke.getText();
        String zvanje = tfZvanje.getText();
        String opis = taOpis.getText();

        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;
        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("AddZaposleni");
            Statement stmt = myConn.createStatement();

            /**
             * kreiranje tipa zaposlenog i onda citanje Id zaposlenog
             */
            String sql = "INSERT INTO tipzaposlenog (opis, zvanje) VALUES ('"+ opis +"', '"+ zvanje +"')";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            sql = "select * from tipzaposlenog where opis = '" + opis + "' and zvanje = '" + zvanje + "'";
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();
            int idTipZaposlenog = 0;
            while(myRS.next()){
                idTipZaposlenog = myRS.getInt("idTipZaposlenog");
            }

            /**
             * kreiranje racuna u banci ako ne postoji u bazi zatim citanje id racuna banke
             *
             */

//            sql = "BEGIN\n" +
//                    "   IF NOT EXISTS (SELECT * FROM racunubanci WHERE brojRacuna = "+brojRacuna+" and imeBanke = '" + nazivBanke + "')\n"+
//                    "   BEGIN\n" +
//                    "       INSERT INTO racunubanci (brojRacuna, imeBanke)\n" +
//                    "       VALUES (" + brojRacuna +", '" + nazivBanke + "')\n" +
//                    "   END\n" +
//                    "END";

            /*sql = "INSERT INTO racunubanci (brojRacuna, imeBanke) \n" +
                    "SELECT stuff for brojRacuna, stuff for imeBanke FROM DUAL \n" +
                    "WHERE NOT EXISTS (SELECT * FROM `table` \n" +
                    "      WHERE `value1`='stuff for value1' AND `value2`='stuff for value2' LIMIT 1) ";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            sql = "SELECT * FROM racunubanci WHERE brojRacuna = " + brojRacuna + " and imeBanke = '" + nazivBanke + "'";
            System.out.println(sql);
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();
            int idRacunUBanci = 0;
            while(myRS.next()){
                idRacunUBanci = myRS.getInt("idRacunUBanci");
            }*/

            /**
             * kreiranje zaposlenog
             */
            sql = "INSERT INTO zaposleni (ime, prezime, jmbg, datumRodjenja, kontakt, email, TipZaposlenog_idTipZaposlenog, RacunUBanci_idRacunUBanci) " +
                    "VALUES ('"+ ime +"', '"+ prezime +"', "+jmbg +", '"+ datumRodjenja + "', "+ kontakt + ", '" + email + "', " + idTipZaposlenog + ", " + 0 +")";
            System.out.println(sql);
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(myConn != null){
                myConn.close();
            }
        }


        changeContent("racunovodja/zaposleni.fxml");
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idAddZaposleniPane.getChildren().removeAll();
        idAddZaposleniPane.getChildren().addAll((root));
    }

}
