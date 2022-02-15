package ui.model;

public class Klijent {

    private int id;
    private String naziv;
    private String adresa;
    private int racun;

    public Klijent(int id, String naziv, String adresa, int racun) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.racun = racun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getRacun() {
        return racun;
    }

    public void setRacun(int racun) {
        this.racun = racun;
    }
}
