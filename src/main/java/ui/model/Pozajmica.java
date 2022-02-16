package ui.model;

import java.util.Date;

/**
 * Created on 16.02.2022. by Andrija inside package ui.model.
 */
public class Pozajmica {

    private int id;
    private String principal;
    private String interest;
    private Date datum;
    private String opis;


    public Pozajmica(int id, String principal, String interest, Date datum, String opis) {
        this.id = id;
        this.principal = principal;
        this.interest = interest;
        this.datum = datum;
        this.opis = opis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
