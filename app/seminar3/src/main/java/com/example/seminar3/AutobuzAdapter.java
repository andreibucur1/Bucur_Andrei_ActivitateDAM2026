package com.example.seminar3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AutobuzAdapter extends BaseAdapter {
    private List<Autobuz> lista = new ArrayList<>();
    private Context context;
    private int resursaLayout;

    public AutobuzAdapter(Context ctx, int resursaLayout, List<Autobuz> lista) {
        this.context = ctx;
        this.resursaLayout = resursaLayout;
        this.lista = lista;
    }



    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(resursaLayout, parent, false);

        Autobuz autobuz = lista.get(position);

        TextView linieTV = v.findViewById(R.id.linieTV);
        TextView producatorTV = v.findViewById(R.id.producatorTV);
        TextView numarLocuriTV = v.findViewById(R.id.numarLocuriTV);
        CheckBox aerConditionatCB = v.findViewById(R.id.aerConditionatCB);

        linieTV.setText(autobuz.getLinie());
        producatorTV.setText(autobuz.getProducator());
        numarLocuriTV.setText(String.valueOf(autobuz.getNumarLocuri()));
        aerConditionatCB.setChecked(autobuz.isAreAerConditionat());

        return v;
    }
}
