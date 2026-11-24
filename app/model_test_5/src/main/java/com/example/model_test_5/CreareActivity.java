package com.example.model_test_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreareActivity extends AppCompatActivity {
    EditText etid;
    EditText etpret;
    RadioGroup rgtitlu;
    RatingBar rbnota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_creare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        etid = findViewById(R.id.andreiBucurId);
        etpret = findViewById(R.id.andreiBucurPret);
        rgtitlu = findViewById(R.id.andreiBucurRadioGroup);
        rbnota = findViewById(R.id.andreiBucurRatingBar);

        Button btnSalveaza = findViewById(R.id.andreiBucurSalveaza);
        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(etid.getText().toString());
                int h = rgtitlu.getCheckedRadioButtonId();
                RadioButton bibi = findViewById(h);
                String titlu = bibi.getText().toString();
                double pret = Double.parseDouble(etpret.getText().toString());
                double nota = rbnota.getNumStars();

                Intent it = new Intent();
                Bundle b = new Bundle();
                Carte c = new Carte(id,titlu, pret, nota);
                b.putParcelable("carte", c);
                it.putExtras(b);
                setResult(RESULT_OK, it);
                finish();
            }
        });

    }
}