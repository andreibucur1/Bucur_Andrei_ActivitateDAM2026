package com.example.model_test_4;

import android.os.Parcel;
import android.os.Parcelable;

public class Cutie implements Parcelable {
    private String cod; // et
    private String culoare; // et
    private double volum; // et
    private int rating; // rat
    private boolean premium; // sw


    public Cutie(String cod, String culoare, double volum, int rating, boolean premium) {
        this.cod = cod;
        this.culoare = culoare;
        this.volum = volum;
        this.rating = rating;
        this.premium = premium;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    @Override
    public String toString() {
        return "Cutie{" +
                "cod='" + cod + '\'' +
                ", culoare='" + culoare + '\'' +
                ", volum=" + volum +
                ", rating=" + rating +
                '}';
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public double getVolum() {
        return volum;
    }

    public void setVolum(double volum) {
        this.volum = volum;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    protected Cutie(Parcel in) {
        // aceeasi ordine ca in writeToParcel
        cod = in.readString();
        culoare = in.readString();
        volum = in.readDouble();
        rating = in.readInt();
        premium = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cod);
        dest.writeString(culoare);
        dest.writeDouble(volum);
        dest.writeInt(rating);
        dest.writeByte((byte) (premium ? 1 : 0)); // writeBoolean cere API 29
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Cutie> CREATOR = new Creator<Cutie>() {
        @Override
        public Cutie createFromParcel(Parcel in) {
            return new Cutie(in);
        }

        @Override
        public Cutie[] newArray(int size) {
            return new Cutie[size];
        }
    };
}
