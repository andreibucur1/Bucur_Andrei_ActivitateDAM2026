package com.example.model_test_3;

import android.os.Parcel;
import android.os.Parcelable;

public class Bicicleta implements Parcelable {
    private String idBicicleta;
    private String model;
    private double pret;
    private String taraOrigine;

    @Override
    public String toString() {
        return "Bicicleta{" +
                "idBicicleta='" + idBicicleta + '\'' +
                ", model='" + model + '\'' +
                ", pret=" + pret +
                ", taraOrigine='" + taraOrigine + '\'' +
                '}';
    }

    public Bicicleta(String idBicicleta, String model, double pret, String taraOrigine) {
        this.idBicicleta = idBicicleta;
        this.model = model;
        this.pret = pret;
        this.taraOrigine = taraOrigine;
    }

    protected Bicicleta(Parcel in) {
        idBicicleta = in.readString();
        model = in.readString();
        pret = in.readDouble();
        taraOrigine = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idBicicleta);
        dest.writeString(model);
        dest.writeDouble(pret);
        dest.writeString(taraOrigine);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Bicicleta> CREATOR = new Creator<Bicicleta>() {
        @Override
        public Bicicleta createFromParcel(Parcel in) {
            return new Bicicleta(in);
        }

        @Override
        public Bicicleta[] newArray(int size) {
            return new Bicicleta[size];
        }
    };

    public String getIdBicicleta() {
        return idBicicleta;
    }

    public void setIdBicicleta(String idBicicleta) {
        this.idBicicleta = idBicicleta;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getTaraOrigine() {
        return taraOrigine;
    }

    public void setTaraOrigine(String taraOrigine) {
        this.taraOrigine = taraOrigine;
    }
}
