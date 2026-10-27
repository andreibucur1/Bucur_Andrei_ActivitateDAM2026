package com.example.lab5;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddBusActivity extends AppCompatActivity {

    private EditText etlinie;
    private EditText etnumarLocuri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_bus);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void salveaza(View view){
        etlinie = findViewById(R.id.etLinie);
        etnumarLocuri = findViewById(R.id.etNumarLocuri);

        String linie = etlinie.getText().toString().trim();
        int nr = Integer.parseInt(etnumarLocuri.getText().toString().trim());

        Autobuz a = new Autobuz(linie, nr);

        Bundle bundle = new Bundle();
        bundle.putSerializable("autobuz", a);
        Intent it = new Intent();
        it.putExtras(bundle);
        setResult(RESULT_OK, it);
        finish();

    }




}