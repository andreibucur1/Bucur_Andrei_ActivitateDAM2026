package com.example.seminar3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugaAutobuzActivity extends AppCompatActivity {

    private EditText etLinie;
    private EditText etNumarLocuri;
    private Spinner spProducator;
    private CheckBox cbAerConditionat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_autobuz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etLinie = findViewById(R.id.etLinie);
        etNumarLocuri = findViewById(R.id.etNumarLocuri);
        spProducator = findViewById(R.id.spProducator);
        cbAerConditionat = findViewById(R.id.cbAerConditionat);

        Button btnSalveaza = findViewById(R.id.btnSalveaza);
        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salveaza();
            }
        });

        Intent it = getIntent();
        if (it.hasExtra("autobuz")) {
            Autobuz autobuz = it.getParcelableExtra("autobuz");

            etLinie.setText(autobuz.getLinie());
            etNumarLocuri.setText(String.valueOf(autobuz.getNumarLocuri()));
            cbAerConditionat.setChecked(autobuz.isAreAerConditionat());

            String[] producatori = getResources().getStringArray(R.array.producatori);
            for (int i = 0; i < producatori.length; i++) {
                if (producatori[i].equals(autobuz.getProducator())) {
                    spProducator.setSelection(i);
                    break;
                }
            }
        }
    }

    private void salveaza() {
        String linie = etLinie.getText().toString().trim();
        String locuriText = etNumarLocuri.getText().toString().trim();

        if (linie.isEmpty()) {
            etLinie.setError(getString(R.string.eroare_camp_obligatoriu));
            return;
        }
        if (locuriText.isEmpty()) {
            etNumarLocuri.setError(getString(R.string.eroare_camp_obligatoriu));
            return;
        }

        int numarLocuri = Integer.parseInt(locuriText);
        String producator = spProducator.getSelectedItem().toString();
        boolean areAerConditionat = cbAerConditionat.isChecked();

        Autobuz autobuz = new Autobuz(linie, numarLocuri, producator, areAerConditionat);

        Bundle bundle = new Bundle();
        bundle.putParcelable("autobuz", autobuz);
        Intent it = new Intent();
        it.putExtras(bundle);
        setResult(RESULT_OK, it);
        finish();
    }
}
