package com.example.exercitiul_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class CaineAdapter extends BaseAdapter {


    private List<Caine> lista;
    private Context context;
    private int resursaLayout;

    public CaineAdapter(List<Caine> lista, Context context, int resursaLayout) {
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

        TextView tvNume = v.findViewById(R.id.textViewNume);
        TextView tvRasa = v.findViewById(R.id.textViewRasa);
        TextView tvVarsta = v.findViewById(R.id.textViewVarsta);
        CheckBox cb = v.findViewById(R.id.checkBox);

        Caine caine = lista.get(position);

        tvNume.setText(caine.getNume());
        tvRasa.setText(caine.getRasa());
        tvVarsta.setText(String.valueOf(caine.getVarsta()));
        cb.setChecked(caine.getTalieMare() == true);



        return v;
    }


}
