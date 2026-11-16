package com.example.model_test_2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Telefon> lista = new ArrayList<>();

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

        Button btnAdaugare = findViewById(R.id.andreiBucurBtnAdaugare);
        btnAdaugare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), AdaugaViewActivity.class);
                startActivityForResult(it, 67);
            }
        });

        Button btnAfisare = findViewById(R.id.buttonAfisare);
        btnAfisare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), AfisareTelefoaneActivity.class);
                Bundle b= new Bundle();
                b.putParcelableArrayList("lista", (ArrayList<? extends Parcelable>) lista);
                it.putExtras(b);
                startActivityForResult(it, 676);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && data != null){
            switch(requestCode){
                case 67:
                    Telefon t = data.getParcelableExtra("telefon");
                    lista.add(t);
                case 676:
                    Intent it = getIntent();
                    lista = it.getParcelableArrayListExtra("lista");
            }
        }
    }
}