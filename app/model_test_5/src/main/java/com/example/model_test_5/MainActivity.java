package com.example.model_test_5;

import static android.widget.Toast.LENGTH_LONG;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
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

    private List<Carte> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnCreare = findViewById(R.id.andreiBucurCreareBtn);
        btnCreare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), CreareActivity.class);

                startActivityForResult(it, 67);
            }
        });

        Button btnAfisare = findViewById(R.id.andreiBucurAfisare);
        btnAfisare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), AfiseazaActivity.class);
                it.putParcelableArrayListExtra("lista", (ArrayList<? extends Parcelable>) lista);
                startActivityForResult(it, 6767);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && data != null){
            switch (requestCode){
                case 67:
                    Carte c = data.getParcelableExtra("carte");
                    lista.add(c);
                    Toast.makeText(getApplicationContext(), c.toString(), LENGTH_LONG).show();
                    break;
                case 6767:
                    ArrayList<Carte> lista_modificata = data.getParcelableArrayListExtra("lista_modificata");
                    lista = lista_modificata;
                    break;
            }
        }
    }
}