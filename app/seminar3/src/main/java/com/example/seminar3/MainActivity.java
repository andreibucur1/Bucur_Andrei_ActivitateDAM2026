package com.example.seminar3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Autobuz> listaAutobuze = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnAdauga = findViewById(R.id.btnOpenActivity);
        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, AdaugaAutobuzActivity.class);
                startActivityForResult(it, 83);
            }
        });

        Button btnAfiseaza = findViewById(R.id.btnShowActivity);
        btnAfiseaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, ShowBusActivity.class);

                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("lista", listaAutobuze);
                it.putExtras(bundle);

                startActivityForResult(it, 84);
            }
        });

        Button btnImagini = findViewById(R.id.btnImagini);
        btnImagini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, ImaginiActivity.class);
                startActivity(it);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 83 && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();
            Autobuz autobuz = bundle.getParcelable("autobuz");
            listaAutobuze.add(autobuz);
            Toast.makeText(this, autobuz.toString(), Toast.LENGTH_LONG).show();
        }
        if (requestCode == 84 && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();
            listaAutobuze = bundle.getParcelableArrayList("lista");
        }
    }
}
