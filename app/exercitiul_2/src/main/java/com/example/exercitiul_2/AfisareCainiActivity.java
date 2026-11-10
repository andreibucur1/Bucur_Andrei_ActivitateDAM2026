package com.example.exercitiul_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class AfisareCainiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_afisare_caini);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle b = getIntent().getExtras();
        List<Caine> caini = (List<Caine>) b.getSerializable("caini");
        ArrayAdapter<Caine> adapter = new ArrayAdapter<Caine>(getApplicationContext(), android.R.layout.simple_list_item_1, caini);
        ListView listview = findViewById(R.id.listViewCaini);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener((parent, view, position, id) -> {
            Caine c = caini.get(position);
            Toast.makeText(this, c.toString(), Toast.LENGTH_SHORT).show();
        });

        listview.setOnItemLongClickListener((parent, view, position, id) -> {
            Caine c = caini.get(position);
            caini.remove(c);
            adapter.notifyDataSetChanged();
            Intent it = new Intent();
            Bundle bb = new Bundle();
            bb.putSerializable("caini", (ArrayList<Caine>)caini);
            it.putExtras(bb);
            setResult(RESULT_OK, it);
            finish();
            return true;
        });


    }
}