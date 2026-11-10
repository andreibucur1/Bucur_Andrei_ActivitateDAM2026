package com.example.exercitiul_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugaCaineActivity extends AppCompatActivity {

    private EditText etNume;
    private Spinner spRasa;
    private RadioGroup rgCuloare;
    private EditText etVarsta;
    private EditText etInaltime;
    private CheckBox cbTalieMare;
    private Switch swSterilizat;
    private RatingBar rbEnergie;
    private Button btnSalveaza;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_caine);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNume = findViewById(R.id.etNume);
        spRasa = findViewById(R.id.spRasa);
        rgCuloare = findViewById(R.id.rgCuloare);

        etVarsta = findViewById(R.id.etVarsta);
        etInaltime = findViewById(R.id.etInaltime);
        cbTalieMare = findViewById(R.id.cbTalieMare);
        swSterilizat = findViewById(R.id.swSterilizat);
        rbEnergie = findViewById(R.id.rbEnergie);
        btnSalveaza = findViewById(R.id.btnSalveaza);

        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nume = etNume.getText().toString();
                String rasa = spRasa.getSelectedItem().toString();
                String culoare = "";
                if (rgCuloare.getCheckedRadioButtonId() == R.id.rbNegru) {
                    culoare = "Negru";
                }
                if (rgCuloare.getCheckedRadioButtonId() == R.id.rbMaro) {
                    culoare = "Maro";
                }
                if (rgCuloare.getCheckedRadioButtonId() == R.id.rbAlb) {
                    culoare = "Alb";
                }
                int varsta = Integer.parseInt(etVarsta.getText().toString());
                float inaltime = Float.parseFloat(etInaltime.getText().toString());
                Boolean talieMare = cbTalieMare.isChecked();
                Boolean sterilizat = swSterilizat.isChecked();
                float energie = rbEnergie.getRating();
                Caine c = new Caine(nume,rasa,culoare,varsta,inaltime,talieMare);
                Intent it = new Intent();
                Bundle b = new Bundle();
                b.putSerializable("caine", c);
                it.putExtras(b);
                setResult(RESULT_OK, it);
                finish();


            }
        });
        }
    }


