package com.example.exercitiul_2;

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

    private List<Caine> caini = new ArrayList<>();

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

        Button btnAdaugaCaine = findViewById(R.id.buttonAdaugaCaine);
        btnAdaugaCaine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), AdaugaCaineActivity.class);
                startActivityForResult(it, 83);
            }
        });

        Button btnAfiseazaCaini = findViewById(R.id.buttonViewCaini);
        btnAfiseazaCaini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), AfisareCainiActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("caini", (ArrayList<Caine>)caini);
                it.putExtras(b);
                startActivityForResult(it, 123);
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && data != null) {
            switch (requestCode) {
                case 83:
                    Caine cainePrimit = (Caine) data.getSerializableExtra("caine");
                    caini.add(cainePrimit);
                    Toast.makeText(this, "caine adaugat", Toast.LENGTH_SHORT).show();
                    break;
                case 123:
                    caini = (List<Caine>) data.getSerializableExtra("caini");
                    break;

            }

        }
    }
}