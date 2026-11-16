package com.example.model_test_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class AdapterT extends BaseAdapter {
    private Context ctx;
    private int resursaLayout;
    private List<Telefon> lista = new ArrayList<>();

    public AdapterT(Context ctx, int resursaLayout, List<Telefon> lista) {
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

        TextView tvId = v.findViewById(R.id.textViewId);
        TextView tvMarca = v.findViewById(R.id.textViewMarca);
        TextView tvPret = v.findViewById(R.id.textViewPret);
        TextView tvSh = v.findViewById(R.id.textViewSh);

        Telefon t = lista.get(position);

        tvId.setText(String.valueOf(t.getIdTelefon()));
        tvMarca.setText(t.getModel());
        tvPret.setText(String.valueOf(t.getCapacitateBaterie()));
        tvSh.setText(t.isEsteSh() ? "este sh" : "nu i sh");

        return v;

    }


}
