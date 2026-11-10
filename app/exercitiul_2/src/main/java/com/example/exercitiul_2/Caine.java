package com.example.exercitiul_2;

import java.io.Serializable;

public class Caine implements Serializable {
    private String nume;
    private String rasa;
    private String culoare;
    private int varsta;
    private float inaltime;
    private Boolean talieMare;

    public Caine(String nume, String rasa, String culoare, int varsta, float inaltime, Boolean talieMare) {
        this.nume = nume;
        this.rasa = rasa;
        this.culoare = culoare;
        this.varsta = varsta;
        this.inaltime = inaltime;
        this.talieMare = talieMare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public float getInaltime() {
        return inaltime;
    }

    public void setInaltime(float inaltime) {
        this.inaltime = inaltime;
    }

    public Boolean getTalieMare() {
        return talieMare;
    }

    public void setTalieMare(Boolean talieMare) {
        this.talieMare = talieMare;
    }

    @Override
    public String toString() {
        return "Caine{" +
                "nume='" + nume + '\'' +
                ", rasa='" + rasa + '\'' +
                ", culoare='" + culoare + '\'' +
                ", varsta=" + varsta +
                ", inaltime=" + inaltime +
                ", talieMare=" + talieMare +
                '}';
    }
}
