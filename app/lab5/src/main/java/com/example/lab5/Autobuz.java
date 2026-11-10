package com.example.lab5;

import java.io.Serializable;

public class Autobuz implements Serializable {
    private String linie;
    private int numarLocuri;


    public Autobuz(String linie, int numarLocuri) {
        this.linie = linie;
        this.numarLocuri = numarLocuri;

    }

    public String getLinie() { return linie; }
    public int getNumarLocuri() { return numarLocuri; }


    @Override
    public String toString() {
        return "Autobuz linia " + linie + ", " + numarLocuri + " locuri, ";
    }
}
