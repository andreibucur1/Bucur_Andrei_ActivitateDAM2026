package com.example.seminar3;

import android.os.Parcel;
import android.os.Parcelable;

public class Autobuz implements Parcelable {
    private String linie;
    private int numarLocuri;
    private String producator;
    private boolean areAerConditionat;

    public Autobuz(String linie, int numarLocuri, String producator,
                   boolean areAerConditionat) {
        this.linie = linie;
        this.numarLocuri = numarLocuri;
        this.producator = producator;
        this.areAerConditionat = areAerConditionat;
    }

    protected Autobuz(Parcel in) {
        linie = in.readString();
        numarLocuri = in.readInt();
        producator = in.readString();
        areAerConditionat = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(linie);
        dest.writeInt(numarLocuri);
        dest.writeString(producator);
        dest.writeByte((byte) (areAerConditionat ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Autobuz> CREATOR = new Creator<Autobuz>() {
        @Override
        public Autobuz createFromParcel(Parcel in) {
            return new Autobuz(in);
        }

        @Override
        public Autobuz[] newArray(int size) {
            return new Autobuz[size];
        }
    };

    public String getLinie() { return linie; }
    public int getNumarLocuri() { return numarLocuri; }
    public String getProducator() { return producator; }
    public boolean isAreAerConditionat() { return areAerConditionat; }

    @Override
    public String toString() {
        return "Autobuz linia " + linie + ", " + numarLocuri + " locuri, "
                + producator
                + ", AC: " + (areAerConditionat ? "da" : "nu");
    }
}
