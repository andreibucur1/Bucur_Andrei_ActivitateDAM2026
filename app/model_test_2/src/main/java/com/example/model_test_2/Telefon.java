package com.example.model_test_2;

import android.os.Parcel;
import android.os.Parcelable;

public class Telefon implements Parcelable {
    private int idTelefon;
    private String model;
    private double capacitateBaterie;
    private boolean esteSh;

    public Telefon(int idTelefon, String model, double capacitateBaterie, boolean esteSh) {
        this.idTelefon = idTelefon;
        this.model = model;
        this.capacitateBaterie = capacitateBaterie;
        this.esteSh = esteSh;
    }

    protected Telefon(Parcel in) {
        idTelefon = in.readInt();
        model = in.readString();
        capacitateBaterie = in.readDouble();
        esteSh = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idTelefon);
        dest.writeString(model);
        dest.writeDouble(capacitateBaterie);
        dest.writeByte((byte) (esteSh ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Telefon> CREATOR = new Creator<Telefon>() {
        @Override
        public Telefon createFromParcel(Parcel in) {
            return new Telefon(in);
        }

        @Override
        public Telefon[] newArray(int size) {
            return new Telefon[size];
        }
    };

    public int getIdTelefon() {
        return idTelefon;
    }

    public String getModel() {
        return model;
    }

    public double getCapacitateBaterie() {
        return capacitateBaterie;
    }

    public boolean isEsteSh() {
        return esteSh;
    }

    public void setIdTelefon(int idTelefon) {
        this.idTelefon = idTelefon;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCapacitateBaterie(double capacitateBaterie) {
        this.capacitateBaterie = capacitateBaterie;
    }

    @Override
    public String toString() {
        return "Telefon{" +
                "idTelefon=" + idTelefon +
                ", model='" + model + '\'' +
                ", capacitateBaterie=" + capacitateBaterie +
                ", esteSh=" + esteSh +
                '}';
    }

    public void setEsteSh(boolean esteSh) {
        this.esteSh = esteSh;
    }
}
