package com.example.exercitiu_lock_in;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Bundle bb = getIntent().getExtras();
        String mesaj = bb.getString("firstString");
        int nr1 = bb.getInt("firstNumber");
        int nr2 = bb.getInt("secondNumber");
        int nr3 = bb.getInt("thirdNumber");

        Toast.makeText(this, mesaj + "; " + nr1 + "; " + nr2 + "; " + nr3, Toast.LENGTH_LONG).show();

        Button bDiscret = findViewById(R.id.buttonDiscret);
        bDiscret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int produs = nr1 * nr2 * nr3;

                Intent it = new Intent();
                it.putExtra("mesajNou", "alt mesaj");
                it.putExtra("produs", produs);
                setResult(RESULT_OK, it);
                finish();
            }
        });
    }


}