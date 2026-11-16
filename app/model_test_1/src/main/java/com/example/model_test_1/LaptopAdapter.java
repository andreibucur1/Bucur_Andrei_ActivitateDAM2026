package com.example.model_test_1;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class LaptopAdapter extends BaseAdapter {

    private List<Laptop> lista = null;
    private Context context;
    private int resursaLayout;

    public LaptopAdapter(List<Laptop> lista, Context context, int resursaLayout) {
        this.lista = lista;
        this.context = context;
        this.resursaLayout = resursaLayout;
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

        Laptop l = lista.get(position);

        TextView tvId = v.findViewById(R.id.andrei_bucur_textViewId);
        TextView tvPret = v.findViewById(R.id.andrei_bucur_textViewPret);
        TextView tvMarca = v.findViewById(R.id.andrei_bucur_textViewMarca);

        tvId.setText(l.getIdLaptop());
        tvMarca.setText();


        return v;
    }
}
