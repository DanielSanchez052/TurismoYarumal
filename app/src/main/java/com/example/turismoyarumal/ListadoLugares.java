package com.example.turismoyarumal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListadoLugares extends AppCompatActivity {
    ImageView imagenLugares;
    TextView tituloLugares, descipcionLugares;
    RecyclerView listadoLugares;

    ArrayList<ElementoTuristico> datosLugares = new ArrayList<>();
    ElementoTuristico lugares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_lugares);

        listadoLugares = findViewById(R.id.rvListadoDetalle);
        listadoLugares.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL , false));

        lugares = (ElementoTuristico) getIntent().getSerializableExtra("lugares");

        datosLugares = lugares.getLugaresTuristicos();

        AdaptadorListadoLugares adaptador = new AdaptadorListadoLugares(datosLugares);
        listadoLugares.setAdapter(adaptador);
    }
}