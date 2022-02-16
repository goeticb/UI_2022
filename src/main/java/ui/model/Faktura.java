package ui.model;

import java.sql.Date;

public class Faktura {

    private int id;
    private int kolicina;
    private int suma;
    private String tipFakture;
    private String opis;
    private Date datum;
    private int idKlijent;
    private String uplatilacTip;
    private int idPdv;
    private int idStavka;

    public Faktura(int id, int kolicina, int suma, String tipFakture, String opis, Date datum, int idKlijent, String uplatilacTip, int idPdv, int idStavka) {
        this.id = id;
        this.kolicina = kolicina;
        this.suma = suma;
        this.tipFakture = tipFakture;
        this.opis = opis;
        this.datum = datum;
        this.idKlijent = idKlijent;
        this.uplatilacTip = uplatilacTip;
        this.idPdv = idPdv;
        this.idStavka = idStavka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public String getTipFakture() {
        return tipFakture;
    }

    public void setTipFakture(String tipFakture) {
        this.tipFakture = tipFakture;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getIdKlijent() {
        return idKlijent;
    }

    public void setIdKlijent(int idKlijent) {
        this.idKlijent = idKlijent;
    }

    public String getUplatilacTip() {
        return uplatilacTip;
    }

    public void setUplatilacTip(String uplatilacTip) {
        this.uplatilacTip = uplatilacTip;
    }

    public int getIdPdv() {
        return idPdv;
    }

    public void setIdPdv(int idPdv) {
        this.idPdv = idPdv;
    }

    public int getIdStavka() {
        return idStavka;
    }

    public void setIdStavka(int idStavka) {
        this.idStavka = idStavka;
    }
}
