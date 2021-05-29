package com.example.turismoyarumal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Locale;

public class  MainActivity extends AppCompatActivity {
    CardView itemMainHoteles;
    CardView itemMainLugares;

    ArrayList<LugarTuristico> listaHoteles = new ArrayList<>();
    ArrayList<LugarTuristico> listaLugares = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemMainHoteles = findViewById(R.id.itemMainHoteles);
        itemMainLugares = findViewById(R.id.itemMainLugares);

        //crearHoteles();
        //crearLugares();

        itemMainHoteles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListadoHoteles.class);
                intent.putExtra("listadoHoteles",listaHoteles);
                startActivity(intent);
                finish();
            }
        });
        itemMainLugares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListadoLugares.class);
                intent.putExtra("listadoLugares",listaLugares);
                startActivity(intent);
                finish();
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        switch (id){
            case(R.id.opcion1):
                cambiarIdioma("en");
                Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
            case(R.id.opcion2):
                cambiarIdioma("es");
                Intent intent2 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent2);
                break;
            case (R.id.opcion3):
                Intent intent3 = new Intent(MainActivity.this,Contribuir.class);
                startActivity(intent3);
                break;
            case(R.id.opcion4):
                Intent intent4 = new Intent(MainActivity.this,AcercaDe.class);
                startActivity(intent4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void cambiarIdioma(String lenguaje){
        Locale idioma = new Locale(lenguaje);
        Locale.setDefault(idioma);

        Configuration configuracionTelefono = getResources().getConfiguration();
        configuracionTelefono.locale=idioma;
        getBaseContext().getResources().updateConfiguration(configuracionTelefono,getBaseContext().getResources().getDisplayMetrics());
    }
}