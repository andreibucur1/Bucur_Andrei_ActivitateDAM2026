package com.example.model_test_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreareLaptopActivity extends AppCompatActivity {

    private EditText etId;

    private EditText etPret;
    private Switch swSh;
    private RadioGroup rgMarca;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_creare_laptop);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etId = findViewById(R.id.bucur_andrei_editTextId);
        etPret = findViewById(R.id.bucur_andrei_editTextPret);
        swSh = findViewById(R.id.bucur_andrei_switch1);
        rgMarca = findViewById(R.id.andrei_bucur_radioGroup);

        Button btn = findViewById(R.id.bucur_andrei_buttonSalvare);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                double pret = Double.parseDouble(etPret.getText().toString());
                RadioButton selectat = findViewById(rgMarca.getCheckedRadioButtonId());
                String marca = selectat.getText().toString();
                boolean sh = swSh.isChecked();
                Intent it = new Intent();
                it.putExtra(getString(R.string.lista), new Laptop(id, marca, pret,sh));
                setResult(RESULT_OK, it);
                finish();
            }
        });

    }
}