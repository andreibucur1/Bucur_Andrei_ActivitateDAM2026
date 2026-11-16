package com.example.model_test_3;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

import java.util.ArrayList;

public class AfisareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_afisare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent it = getIntent();
        ArrayList<Bicicleta> lista = it.getParcelableArrayListExtra("lista");
        AdapterBic adapterBic = new AdapterBic(this, R.layout.item, lista);

        ListView lv = findViewById(R.id.andreiBucurLv);
        lv.setAdapter(adapterBic);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bicicleta b = lista.get(position);
                Toast.makeText(getApplicationContext(), b.toString(), LENGTH_SHORT).show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Bicicleta b = lista.get(position);
                b.setPret(b.getPret()*0.9);
                adapterBic.notifyDataSetChanged();
                return false;
            }
        });
    }
}