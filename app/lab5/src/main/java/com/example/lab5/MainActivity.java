package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    static List<Autobuz> listaAutobuze = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void openActivity(View view) {
        Intent it = new Intent(this, AddBusActivity.class);
        startActivityForResult(it, 83);

    }

    public void showActivity(View view) {
        Intent it = new Intent(this, ShowBusActivity.class);
        startActivity(it);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 83 && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();
            Autobuz autobuz = (Autobuz) bundle.getSerializable("autobuz");
            listaAutobuze.add(autobuz);
            Toast.makeText(this, autobuz.toString(), Toast.LENGTH_LONG).show();
        }
    }


}