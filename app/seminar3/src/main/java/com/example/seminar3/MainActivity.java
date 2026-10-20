package com.example.seminar3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvAutobuz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void openActivity(View view) {
        tvAutobuz = findViewById(R.id.tvAutobuz);
        Intent it = new Intent(this, AdaugaAutobuzActivity.class);
        startActivityForResult(it, 83);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 83 && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();
            Autobuz autobuz = (Autobuz) bundle.getSerializable("autobuz");
            tvAutobuz.setText(autobuz.toString());
            Toast.makeText(this, autobuz.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
