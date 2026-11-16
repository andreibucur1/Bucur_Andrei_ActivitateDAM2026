package com.example.model_test_4;

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
    private int resourceLayout;
    private List<Cutie> l = new ArrayList<>();
    @Override
    public int getCount() {
        return l.size();
    }

    public AdapterC(Context ctx, int resourceLayout, List<Cutie> l) {
        this.ctx = ctx;
        this.resourceLayout = resourceLayout;
        this.l = l;
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
        View v = inflater.inflate(resourceLayout, parent, false);

        TextView tvid = v.findViewById(R.id.andreiBucurtextView);
        TextView tvculaore = v.findViewById(R.id.andreiBucurtextView2);
        TextView tvvolum = v.findViewById(R.id.andreiBucurtextView3);
        TextView tvpremium = v.findViewById(R.id.andreiBucurtextView4);
        TextView tvrating = v.findViewById(R.id.andreiBucurtextView5);

        Cutie c = l.get(position);

        tvid.setText(c.getCod());
        tvculaore.setText(c.getCuloare());
        tvvolum.setText(String.valueOf(c.getVolum()));
        tvpremium.setText(c.isPremium() ? ctx.getString(R.string.premium) : ctx.getString(R.string.nupremium));
        tvrating.setText(String.valueOf(c.getRating()));

        return v;

    }
}
