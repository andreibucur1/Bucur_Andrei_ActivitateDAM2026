package com.example.model_test_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterC extends BaseAdapter {
    private Context ctx;
    private int resursaLayout;
    private List<Carte> lista = new ArrayList<>();

    public AdapterC(Context ctx, int resursaLayout, List<Carte> lista) {
        this.ctx = ctx;
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
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout, parent, false);

        TextView tvid = v.findViewById(R.id.andreiBucurTV1);
        TextView tvtitlu = v.findViewById(R.id.andreiBucurTV2);
        TextView tvpret = v.findViewById(R.id.andreiBucurTV3);
        TextView tvnota = v.findViewById(R.id.andreiBucurTV4);

        Carte c = lista.get(position);

        tvid.setText(String.valueOf(c.getCarte()));
        tvtitlu.setText(c.getTitlu());
        tvpret.setText(String.valueOf(c.getPret()));
        tvnota.setText(String.valueOf(c.getNota()));

        return v;
    }
}
