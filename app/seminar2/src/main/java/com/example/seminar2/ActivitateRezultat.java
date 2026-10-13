package com.example.seminar2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateRezultat extends AppCompatActivity {

    int numar1;
    int numar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_rezultat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        String mesaj = bundle.getString("mesaj");
        this.numar1 = bundle.getInt("numar1", 0);
        this.numar2 = bundle.getInt("numar2", 0);
        Toast.makeText(this, mesaj, Toast.LENGTH_SHORT).show();

    }

    public void intoarcereActivitateRezultat(View view){
        int suma = this.numar1 + this.numar2;
        String mesajNou = "noul mesaj";
        Intent it = new Intent();
        it.putExtra("mesaj", mesajNou);
        it.putExtra("suma", suma);
        setResult(RESULT_OK, it);
        finish();

    }
}