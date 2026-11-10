package com.example.seminar3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImagineAdapter extends BaseAdapter {
    private List<ImaginiDomeniu> lista;
    private Context context;
    private int resursaLayout;

    public ImagineAdapter(List<ImaginiDomeniu> lista, Context context, int resursaLayout) {
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(resursaLayout, parent, false);

        ImageView imagineIV = v.findViewById(R.id.imagineIV);
        TextView descriereTV = v.findViewById(R.id.descriereTV);

        ImaginiDomeniu element = (ImaginiDomeniu) getItem(position);

        imagineIV.setImageBitmap(element.getImagine());
        descriereTV.setText(element.getTextAfisat());

        return v;
    }
}
