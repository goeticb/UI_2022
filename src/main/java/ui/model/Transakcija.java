package ui.model;

import java.sql.Date;

public class Transakcija {
    private int id;
    private Date date;
    private int suma;
    private String tipTransakcije;
    private int fakturaId;

    public Transakcija(int id, Date date, int suma, String tipTransakcije, int fakturaId) {
        this.id = id;
        this.date = date;
        this.suma = suma;
        this.tipTransakcije = tipTransakcije;
        this.fakturaId = fakturaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public String getTipTransakcije() {
        return tipTransakcije;
    }

    public void setTipTransakcije(String tipTransakcije) {
        this.tipTransakcije = tipTransakcije;
    }

    public int getFakturaId() {
        return fakturaId;
    }

    public void setFakturad(int fakturad) {
        this.fakturaId = fakturad;
    }
}
