package com.example.model_test_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugaViewActivity extends AppCompatActivity {

    EditText etId;
    EditText etBat;

    Spinner spMarca;
    RatingBar rbSh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etId = findViewById(R.id.editTextId);
        etBat  =findViewById(R.id.editTextName);
        spMarca = findViewById(R.id.spinner);
        rbSh = findViewById(R.id.ratingBar);

        Button b = findViewById(R.id.buttonSalvare);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(etId.getText().toString());
                double baterie = Double.parseDouble(etBat.getText().toString());
                String marca = spMarca.getSelectedItem().toString();
                boolean sh = (rbSh.getNumStars() == 2);

                Telefon t = new Telefon(id, marca, baterie, sh);
                Intent it = new Intent();
                Bundle b = new Bundle();
                b.putParcelable("telefon", t);
                it.putExtras(b);
                setResult(RESULT_OK, it);
                finish();
            }
        });





    }



}