package com.example.turismoyarumal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListadoHoteles extends AppCompatActivity {
    /**
     * Clase que me ayuda con el RecyclerView que me muestra los lugares individuales de la app
     * XML: activity_listado_hoteles.xml
     */
    RecyclerView listadoLugares;

    ArrayList<LugarTuristico> listadoHoteles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_hoteles);

        listadoLugares = findViewById(R.id.rvListadoDetalle);
        listadoLugares.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL , false));

        listadoHoteles = (ArrayList<LugarTuristico>) getIntent().getSerializableExtra("listadoHoteles");

        AdaptadorHoteles adaptador = new AdaptadorHoteles(listadoHoteles);
        listadoLugares.setAdapter(adaptador);
    }
}