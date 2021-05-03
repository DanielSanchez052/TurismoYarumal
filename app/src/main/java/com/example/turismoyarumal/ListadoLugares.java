package com.example.turismoyarumal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListadoLugares extends AppCompatActivity {
    /**
     * Clase que me ayuda con el RecyclerView que me muestra los lugares individuales de la app
     * XML: activity_listado_lugares.xml
     */
    RecyclerView rvListadoLugares;

    ArrayList<LugarTuristico> listadoLugares= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_lugares);

        rvListadoLugares = findViewById(R.id.rvListadoLugares);
        rvListadoLugares.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL , false));

        listadoLugares = (ArrayList<LugarTuristico>) getIntent().getSerializableExtra("listadoLugares");

        AdaptadorLugares adaptador = new AdaptadorLugares(listadoLugares);
        rvListadoLugares.setAdapter(adaptador);
    }
}