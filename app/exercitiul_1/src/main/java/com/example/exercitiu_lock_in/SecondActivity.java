package com.example.exercitiu_lock_in;

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

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnZaza = findViewById(R.id.buttonZapada);
        btnZaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), ThirdActivity.class);
                Bundle b = new Bundle();
                b.putString("firstString", "Ronaldo e mai bun ca mesi rege ba siuuuu");
                b.putInt("firstNumber", 5);
                b.putInt("secondNumber", 15);
                b.putInt("thirdNumber", 45);
                it.putExtras(b);

                startActivityForResult(it, 83);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 83 && resultCode == RESULT_OK && data != null) {
            data.getStringExtra("mesajNou");
            int produs = data.getIntExtra("produs", 0);
            TextView t = findViewById(R.id.textViewProdus);
            t.setText("produsul este: " +  produs);

        }
    }
}




