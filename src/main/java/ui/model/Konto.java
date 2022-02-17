package ui.model;

/**
 * Created on 16.02.2022. by Andrija inside package ui.model.
 */
public class Konto {

    private int id;
    private String sifra;
    private String ime;
    private double duguje;
    private double potrazuje;
    private String a_p_r_p;

    public Konto(int id, String sifra, String ime, double duguje, double potrazuje, String a_p_r_p) {
        this.id = id;
        this.sifra = sifra;
        this.ime = ime;
        this.duguje = duguje;
        this.potrazuje = potrazuje;
        this.a_p_r_p = a_p_r_p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getDuguje() {
        return duguje;
    }

    public void setDuguje(double duguje) {
        this.duguje = duguje;
    }

    public double getPotrazuje() {
        return potrazuje;
    }

    public void setPotrazuje(double potrazuje) {
        this.potrazuje = potrazuje;
    }

    public String getA_p_r_p() {
        return a_p_r_p;
    }

    public void setA_p_r_p(String a_p_r_p) {
        this.a_p_r_p = a_p_r_p;
    }
}
