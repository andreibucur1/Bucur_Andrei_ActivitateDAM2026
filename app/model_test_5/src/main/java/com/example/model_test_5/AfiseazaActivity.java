package com.example.model_test_5;

import static android.widget.Toast.LENGTH_LONG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class AfiseazaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_afiseaza);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent it = getIntent();
        ArrayList<Carte> l = it.getParcelableArrayListExtra("lista");
        AdapterC adapterC = new AdapterC(this, R.layout.item, l);
        ListView lv = findViewById(R.id.andreiBucurLv);
        lv.setAdapter(adapterC);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Carte c = l.get(position);
                Toast.makeText(getApplicationContext(), c.toString(), LENGTH_LONG).show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Carte c = l.get(position);
                c.setPret(c.getPret() * 1.1);
                adapterC.notifyDataSetChanged();
                Intent it = new Intent();
                it.putParcelableArrayListExtra("lista_modificata", l);
                setResult(RESULT_OK, it);
                finish();
                return true;
            }
        });
    }
}