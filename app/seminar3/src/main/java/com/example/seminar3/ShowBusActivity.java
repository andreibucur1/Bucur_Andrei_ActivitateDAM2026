package com.example.seminar3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ShowBusActivity extends AppCompatActivity {

    private ArrayList<Autobuz> lista = null;
    private int idModificat = 0;
    private AutobuzAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_bus);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle = getIntent().getExtras();
        ListView lv = findViewById(R.id.lvAutobuze);
        lista = bundle.getParcelableArrayList("lista");

        adapter = new AutobuzAdapter(this, R.layout.adapter, lista);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Autobuz autobuzSelectat = lista.get(position);

                Intent it = new Intent(ShowBusActivity.this, AdaugaAutobuzActivity.class);
                it.putExtra("autobuz", autobuzSelectat);
                idModificat = position;
                startActivityForResult(it, 85);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                lista.remove(position);
                adapter.notifyDataSetChanged();
                trimiteListaInapoi();
                return true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 85 && resultCode == RESULT_OK && data != null) {
            Autobuz modificat = data.getParcelableExtra("autobuz");
            lista.set(idModificat, modificat);
            adapter.notifyDataSetChanged();
            trimiteListaInapoi();
        }
    }

    private void trimiteListaInapoi() {
        Intent it = new Intent();
        Bundle b = new Bundle();
        b.putParcelableArrayList("lista", lista);
        it.putExtras(b);
        setResult(RESULT_OK, it);
    }
}
