package com.example.turismoyarumal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    /**
     * Clase que me ayuda con la actividad que se ejecuta al iniciar la app
     * XML: activity_splash.html
     */
    MediaPlayer sonido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        sonido= MediaPlayer.create(this, R.raw.sentarse);
        sonido.start();
        TimerTask inicio = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(inicio,6100);
    }
}