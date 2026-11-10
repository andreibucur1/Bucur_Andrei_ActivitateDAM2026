package com.example.seminar3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImaginiActivity extends AppCompatActivity {

    private List<ImaginiDomeniu> lista = new ArrayList<>();
    private ImagineAdapter adapter = null;


    private final String[] linkuriImagini = {
            "https://commons.wikimedia.org/wiki/Special:FilePath/Steering_Wheel_of_Honda_City_7th_Generation_(5th_Generation_Sedan)_iVTEC_2022.jpg?width=400",
            "https://commons.wikimedia.org/wiki/Special:FilePath/Passengers_in_Amtrak_lounge_car_of_San_Joaquin_(train)_2014.jpg?width=400",
            "https://commons.wikimedia.org/wiki/Special:FilePath/Otokar_Kent_C_6556_at_Universitate.jpg?width=400",
            "https://commons.wikimedia.org/wiki/Special:FilePath/Red_and_green_traffic_signals,_Stamford_Road,_Singapore_-_20111210.jpg?width=400",
            "https://commons.wikimedia.org/wiki/Special:FilePath/Rocar_105.jpg?width=400"
    };
    private final String[] texte = {
            "Volan",
            "Pasageri",
            "Autobuz Otokar Kent",
            "Semafor",
            "Autobuz ROCAR"
    };
    private final String[] linkuriPagini = {
            "https://en.wikipedia.org/wiki/Steering_wheel",
            "https://ro.wikipedia.org/wiki/Pasager",
            "https://ro.wikipedia.org/wiki/Autobuz",
            "https://ro.wikipedia.org/wiki/Semafor",
            "https://ro.wikipedia.org/wiki/ROCAR_412U"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imagini);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView lv = findViewById(R.id.imagini);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(getApplicationContext(), WebViewActivity.class);
                it.putExtra("link", lista.get(i).getLink());
                startActivity(it);
            }
        });

        // descarcarea imaginilor pe seoncd thread
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                //descarc imginile
                List<Bitmap> imagini = new ArrayList<>();
                for (String link : linkuriImagini) {
                    HttpURLConnection con = null;
                    Bitmap bitmap = null;
                    try {
                        URL url = new URL(link);
                        con = (HttpURLConnection) url.openConnection();
                        InputStream is = con.getInputStream();
                        bitmap = BitmapFactory.decodeStream(is);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (con != null) {
                            con.disconnect();
                        }
                    }
                    imagini.add(bitmap);
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < imagini.size(); i++) {
                            lista.add(new ImaginiDomeniu(texte[i], imagini.get(i), linkuriPagini[i]));
                        }
                        adapter = new ImagineAdapter(lista, getApplicationContext(), R.layout.imagine_layout);
                        lv.setAdapter(adapter);
                    }
                });
            }
        });
    }
}
