package ui.model;

import java.util.Date;

/**
 * Created on 17.02.2022. by Andrija inside package ui.model.
 */
public class Zaposleni {
    private int id;
    private String ime;
    private String prezime;
    private int jmbg;
    private Date datumRodjenja;
    private int kontakt;
    private String email;
    private String zvanje;

    public Zaposleni(int id, String ime, String prezime, int jmbg, Date datumRodjenja, int kontakt, String email, String zvanje) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.datumRodjenja = datumRodjenja;
        this.kontakt = kontakt;
        this.email = email;
        this.zvanje = zvanje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getJmbg() {
        return jmbg;
    }

    public void setJmbg(int jmbg) {
        this.jmbg = jmbg;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public int getKontakt() {
        return kontakt;
    }

    public void setKontakt(int kontakt) {
        this.kontakt = kontakt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZvanje() {
        return zvanje;
    }

    public void setZvanje(String zvanje) {
        this.zvanje = zvanje;
    }
}
