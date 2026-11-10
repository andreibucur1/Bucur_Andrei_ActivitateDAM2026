package com.example.exercitiu_lock_in;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("EROARE_RESUME", "onResume: eroare simulata");
        Log.w("AVERT_RESUME", "onResume: avertisment");
        Log.d("DEBUG_RESUME", "onResume: debug");
        Log.i("INFO_RESUME", "onResume: info");
        Log.v("VERBOSE_RESUME", "onResume: verbose");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("EROARE_START", "onStart: eroare simulata");
        Log.w("AVERT_START", "onStart: avertisment");
        Log.d("DEBUG_START", "onStart: debug");
        Log.i("INFO_START", "onStart: info");
        Log.v("VERBOSE_START", "onStart: verbose");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("EROARE_PAUSE", "onPause: eroare simulata");
        Log.w("AVERT_PAUSE", "onPause: avertisment");
        Log.d("DEBUG_PAUSE", "onPause: debug");
        Log.i("INFO_PAUSE", "onPause: info");
        Log.v("VERBOSE_PAUSE", "onPause: verbose");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("EROARE_STOP", "onStop: eroare simulata");
        Log.w("AVERT_STOP", "onStop: avertisment");
        Log.d("DEBUG_STOP", "onStop: debug");
        Log.i("INFO_STOP", "onStop: info");
        Log.v("VERBOSE_STOP", "onStop: verbose");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("EROARE_DESTROY", "onDestroy: eroare simulata");
        Log.w("AVERT_DESTROY", "onDestroy: avertisment");
        Log.d("DEBUG_DESTROY", "onDestroy: debug");
        Log.i("INFO_DESTROY", "onDestroy: info");
        Log.v("VERBOSE_DESTROY", "onDestroy: verbose");
    }


}