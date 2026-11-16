package com.example.model_test_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterBic extends BaseAdapter {

    private Context ctx;
    private int resursaLayout;

    public AdapterBic(Context ctx, int resursaLayout, List<Bicicleta> l) {
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
        this.l = l;
    }

    private List<Bicicleta> l = new ArrayList<>();
    @Override
    public int getCount() {
        return l.size();
    }

    @Override
    public Object getItem(int position) {
        return l.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout, parent, false);

        TextView tvId = v.findViewById(R.id.textView61);
        TextView tvPret = v.findViewById(R.id.textView62);
        TextView tvModel = v.findViewById(R.id.textView63);
        TextView tvTara = v.findViewById(R.id.textView64);

        Bicicleta b = l.get(position);

        tvId.setText(b.getIdBicicleta());
        tvPret.setText(String.valueOf(b.getPret()));
        tvModel.setText(b.getModel());
        tvTara.setText(b.getTaraOrigine());



        return v;

    }
}
