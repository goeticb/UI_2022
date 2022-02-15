package ui.model;

public class Racun {
    private int id;
    private int broj;
    private String imeBanke;

    public Racun(int id, int broj, String imeBanke) {
        this.id = id;
        this.broj = broj;
        this.imeBanke = imeBanke;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public String getImeBanke() {
        return imeBanke;
    }

    public void setImeBanke(String imeBanke) {
        this.imeBanke = imeBanke;
    }
}
