package ui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import ui.model.Konto;
import ui.model.Racun;
import ui.model.Zaposleni;
import ui.ui2021.App;

import java.io.IOException;
import java.sql.*;
import java.util.Date;

public class ZaposleniController {


    @FXML
    private Pane idZaposneliPaneRacunovodja;

    @FXML
    private Button btTipRacunovodja;
    @FXML
    private Button btProjekatRacunovodja;

    @FXML
    private Button btAddZaposleni;

    @FXML
    private Button btIzmeniZaposleni;

    @FXML
    private Button btDeleteZaposleni;

    @FXML
    private TableColumn<Racun, Integer> tcId;

    @FXML
    private TableColumn<Racun, String> tcIme;

    @FXML
    private TableColumn<Racun, String> tcPrezime;

    @FXML
    private TableColumn<Racun, Integer> tcJmbg;

    @FXML
    private TableColumn<Racun, Date> tcDatumRodjenja;

    @FXML
    private TableColumn<Racun, Integer> tcKontakt;

    @FXML
    private TableColumn<Racun, String> tcEmail;

    @FXML
    private TableColumn<Racun, String> tcZvanje;

    @FXML
    private TableView<Zaposleni> tvZaposleni;

    @FXML
    public void initialize() {
        tcId.setCellValueFactory(new PropertyValueFactory("id"));
        tcIme.setCellValueFactory(new PropertyValueFactory("ime"));
        tcPrezime.setCellValueFactory(new PropertyValueFactory("prezime"));
        tcJmbg.setCellValueFactory(new PropertyValueFactory("jmbg"));
        tcDatumRodjenja.setCellValueFactory(new PropertyValueFactory("datumRodjenja"));
        tcKontakt.setCellValueFactory(new PropertyValueFactory("kontakt"));
        tcEmail.setCellValueFactory(new PropertyValueFactory("email"));
        tcZvanje.setCellValueFactory(new PropertyValueFactory("zvanje"));

        //System.out.println("USO JE Ovde Scene BilderFaktura");
        try {
            ucitajZaposlene();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void tip(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/tip.fxml");
    }

    public void projekat(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/projekat.fxml");
    }

    public void addZaposleni(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/addZaposleni.fxml");
    }

    public void deleteZaposleni(ActionEvent actionEvent) {
    }

    public void izmeniZaposleni(ActionEvent actionEvent) throws IOException {
        changeContent("racunovodja/izmeniZaposleni.fxml");
    }

    public void logOut(ActionEvent actionEvent) throws IOException {
        App.getInstance().changeScene("login.fxml");
    }

    public void ucitajZaposlene() throws SQLException {
        ObservableList<Zaposleni> list = FXCollections.observableArrayList();
        String dbURL = "jdbc:mysql://localhost:3306/mydb";

        Connection myConn = null;
        ResultSet myRS = null;
        PreparedStatement p = null;

        try {
            myConn = DriverManager.getConnection(dbURL, App.getUser(), App.getPass());
            System.out.println("prosaoKlijent");
            String sql = "select * from zaposleni";
            p = myConn.prepareStatement(sql);
            myRS = p.executeQuery();

            while(myRS.next()){
                //System.out.println("KLIJENT");

                int id = myRS.getInt("idZaposleni");
                String ime = myRS.getString("ime");
                String prezime = myRS.getString("prezime");
                int jmbg = myRS.getInt("jmbg");
                Date datumRodjenja = myRS.getDate("datumRodjenja");
                int kontakt = myRS.getInt("kontakt");
                String email = myRS.getString("email");
                String zvanje="";
                sql = "select * from tipzaposlenog where idTipZaposlenog = " + myRS.getInt("TipZaposlenog_idTipZaposlenog");
                System.out.println(sql);
                p = myConn.prepareStatement(sql);
                ResultSet mysubRS = p.executeQuery();
                while(mysubRS.next()){
                    zvanje = mysubRS.getString("zvanje");
                }

                Zaposleni zaposleni = new Zaposleni(id,ime,prezime,jmbg,datumRodjenja,kontakt, email, zvanje);
                System.out.println(zaposleni.getId());
                list.add(zaposleni);
                tvZaposleni.setItems(list);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(myConn != null){
                myConn.close();
            }
            if(myRS != null){
                myRS.close();
            }
        }
    }

    public void changeContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        idZaposneliPaneRacunovodja.getChildren().removeAll();
        idZaposneliPaneRacunovodja.getChildren().addAll((root));
    }


}
