package com.example.turismoyarumal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

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

        crearHoteles();
        crearLugares();

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

    private void crearHoteles(){
        listaHoteles.add(new LugarTuristico(
                R.drawable.panorama_hotel,
                "Panorama Hotel",
                getString(R.string.panoramaDescripcion),
                "Contacto: 314 6577826",
                "Dirección: Carrera 20 # 19-37"
        ));

        listaHoteles.add(new LugarTuristico(
                R.drawable.armonia_hotel,
                "Armonia Hotel",
                getString(R.string.armoniaDescripcion),
                "Contacto: 310 8040253",
                "Dirección: Carrera 25 # 14-104"));

        listaHoteles.add(new LugarTuristico(
                R.drawable.amajari_hotel,
                "Hotel Amajari",
                getString(R.string.amajariDescripcion),
                "Contacto: 8538866 Y 8870866",
                "Dirección: Carrera 20 # 19-18"));

        listaHoteles.add(new LugarTuristico(
                R.drawable.gran_hotel,
                "Gran Hotel",
                getString(R.string.granDescripcion),
                "Contacto: 313 6092506",
                "Dirección: Carrera 20 # 21-25"));

        listaHoteles.add(new LugarTuristico(
                R.drawable.relax_hotel,
                "Hotel Relax",
                getString(R.string.relaxDescripcion),
                "Contacto: 8872903 y 3207269868",
                "Dirección: Calle 21 # 21-78"));
    }

    private void crearLugares(){
        listaLugares.add(new LugarTuristico(
                R.drawable.mayarino_lugar1,
                "Mallarino(El puente)",
                getString(R.string.mayarinoDescripcion),
                "",
                "Dirección: Estadero Los Charcos De Mallarino"));
        listaLugares.add(new LugarTuristico(
                R.drawable.parque_principal,
                "Parque Principal",
                getString(R.string.parqueDescripcion),
                "",
                "Dirección: El parque principal"));
        listaLugares.add(new LugarTuristico(
                R.drawable.preventorio_lugar1,
                "Parque Recreativo Ruben Piedrahita Arango",
                getString(R.string.preventorioDescripcion),
                "",
                "Dirección: El preventorio"));
        listaLugares.add(new LugarTuristico(
                R.drawable.coliseo_lugar1,
                "El coliseo del café",
                getString(R.string.coliseoDescipcion),
                "",
                "Dirección: Calle. 12 #23-46"));
    }
}