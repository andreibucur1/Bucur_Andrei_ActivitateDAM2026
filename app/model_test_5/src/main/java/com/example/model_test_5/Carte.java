package com.example.model_test_5;

import android.os.Parcel;
import android.os.Parcelable;

public class Carte implements Parcelable {
    private int carte;
    private String titlu;
    private double pret;
    private double nota;

    @Override
    public String toString() {
        return "Carte{" +
                "carte=" + carte +
                ", titlu='" + titlu + '\'' +
                ", pret=" + pret +
                ", nota=" + nota +
                '}';
    }

    protected Carte(Parcel in) {
        carte = in.readInt();
        titlu = in.readString();
        pret = in.readDouble();
        nota = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(carte);
        dest.writeString(titlu);
        dest.writeDouble(pret);
        dest.writeDouble(nota);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Carte> CREATOR = new Creator<Carte>() {
        @Override
        public Carte createFromParcel(Parcel in) {
            return new Carte(in);
        }

        @Override
        public Carte[] newArray(int size) {
            return new Carte[size];
        }
    };

    public int getCarte() {
        return carte;
    }

    public void setCarte(int carte) {
        this.carte = carte;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Carte(int carte, String titlu, double pret, double nota) {
        this.carte = carte;
        this.titlu = titlu;
        this.pret = pret;
        this.nota = nota;
    }
}
