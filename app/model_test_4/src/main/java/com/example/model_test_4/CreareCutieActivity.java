package com.example.model_test_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreareCutieActivity extends AppCompatActivity {

    EditText etid;
    EditText etculoare;
    EditText etvolum;
    Switch swPremium;
    RatingBar rbRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_creare_cutie);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etid = findViewById(R.id.andreiBucurEditTextText);
        etculoare = findViewById(R.id.andreiBucurEditTextText2);
        etvolum = findViewById(R.id.andreiBucurEditTextText3);
        swPremium = findViewById(R.id.andreiBucurSwitch1);
        rbRating = findViewById(R.id.andreiBucurRatingBar);

        Button btnSalveaza = findViewById(R.id.andreiBucurButtonSalveaza);
        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etid.getText().toString();
                String culoare = etculoare.getText().toString();
                double vol = Double.parseDouble(etvolum.getText().toString());
                boolean premium = swPremium.isChecked();
                int rating = (int)rbRating.getRating();
                Cutie c = new Cutie(id, culoare, vol, rating, premium);
                Bundle b = new Bundle();
                b.putParcelable("cutie", c);
                Intent it = new Intent();
                it.putExtras(b);
                setResult(RESULT_OK, it);
                finish();

            }
        });

    }
}