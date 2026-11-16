package com.example.model_test_1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Laptop implements Parcelable {
    private String idLaptop;
    private String marca;
    private double pret;
    private boolean esteSh;

    public Laptop(String idLaptop, String marca, double pret, boolean esteSh) {
        this.idLaptop = idLaptop;
        this.marca = marca;
        this.pret = pret;
        this.esteSh = esteSh;
    }

    protected Laptop(Parcel in) {
        idLaptop = in.readString();
        marca = in.readString();
        pret = in.readDouble();
        esteSh = in.readByte() != 0;
    }

    public static final Creator<Laptop> CREATOR = new Creator<Laptop>() {
        @Override
        public Laptop createFromParcel(Parcel in) {
            return new Laptop(in);
        }

        @Override
        public Laptop[] newArray(int size) {
            return new Laptop[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(idLaptop);
        dest.writeString(marca);
        dest.writeDouble(pret);
        dest.writeByte((byte) (esteSh ? 1 : 0));
    }

    public String getIdLaptop() {
        return idLaptop;
    }

    public String getMarca() {
        return marca;
    }

    public double getPret() {
        return pret;
    }

    public boolean isEsteSh() {
        return esteSh;
    }
}
