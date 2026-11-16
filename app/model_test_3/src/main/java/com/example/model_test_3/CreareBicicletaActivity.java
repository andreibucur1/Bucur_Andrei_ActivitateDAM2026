package com.example.model_test_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreareBicicletaActivity extends AppCompatActivity {
    EditText etId;
    EditText etPret;
    Spinner spModel;
    RadioGroup rgTari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_creare_bicicleta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etId = findViewById(R.id.andreiBucurEtId);
        etPret = findViewById(R.id.andreiBucurEtPret);
        spModel = findViewById(R.id.andreiBucurSpinner);
        rgTari = findViewById(R.id.andreiBucurRadioGroup);

        Button btnAdauga = findViewById(R.id.andreiBucurAdaugaBtn);
        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                double pret = Double.parseDouble(etPret.getText().toString());
                String model = spModel.getSelectedItem().toString();
                int h = rgTari.getCheckedRadioButtonId();
                RadioButton GGG = findViewById(h);
                String tara = GGG.getText().toString();
                Bicicleta bic = new Bicicleta(id, model, pret, tara);
                Intent it = new Intent();
                Bundle b = new Bundle();
                b.putParcelable("bicicleta",bic);
                it.putExtras(b);
                setResult(RESULT_OK, it);
                finish();

            }
        });



    }
}