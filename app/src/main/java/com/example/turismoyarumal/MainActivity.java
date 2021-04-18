package com.example.turismoyarumal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ElementoTuristico> listaDatos;
    ArrayList<ElementoTuristico> listaHoteles;
    ArrayList<ElementoTuristico> listaLugares;
    RecyclerView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listado = findViewById(R.id.rvListado);
        listado.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        listaDatos = new ArrayList<>();
        listaHoteles = new ArrayList<>();
        listaLugares = new ArrayList<>();

        crearListado();

        AdaptadorLista adaptador = new AdaptadorLista(listaDatos);
        listado.setAdapter(adaptador);
    }

    private void crearListado() {
        crearHoteles();
        crearLugares();

        listaDatos.add(new ElementoTuristico(R.drawable.parque_principal,"Lugares de interes",listaLugares));
        listaDatos.add(new ElementoTuristico(R.drawable.panorama_hotel,"Hoteles",listaHoteles));

        listaDatos.add(new ElementoTuristico(R.drawable.contactenos_md,"Contactenos Aquí"));
    }

    private void crearHoteles(){
         listaHoteles.add(new ElementoTuristico(
                R.drawable.panorama_hotel,
                "Panorama Hotel",
                 getString(R.string.panoramaDescripcion),
                 "Contacto: 314 6577826",
                 "Dirección: Carrera 20 # 19-37"
                ));

        listaHoteles.add(new ElementoTuristico(
                R.drawable.armonia_hotel,
                "Armonia Hotel",
                getString(R.string.armoniaDescripcion),
                "Contacto: 310 8040253",
                "Dirección: Carrera 25 # 14-104"));

        listaHoteles.add(new ElementoTuristico(
                R.drawable.amajari_hotel,
                "Hotel Amajari",
                getString(R.string.amajariDescripcion),
                "Contacto: 8538866 Y 8870866",
                "Dirección: Carrera 20 # 19-18"));

        listaHoteles.add(new ElementoTuristico(
                R.drawable.gran_hotel,
                "Gran Hotel",
                getString(R.string.granDescripcion),
                "Contacto: 313 6092506",
                "Dirección: Carrera 20 # 21-25"));

        listaHoteles.add(new ElementoTuristico(
                R.drawable.relax_hotel,
                "Hotel Relax",
                getString(R.string.relaxDescripcion),
                "Contacto: 8872903 y 3207269868",
                "Dirección: Calle 21 # 21-78"));
    }

    private void crearLugares(){
        listaLugares.add(new ElementoTuristico(
                R.drawable.mayarino_lugar1,
                "Mallarino(El puente)",
                getString(R.string.mayarinoDescripcion),
                "",
                "Dirección: Estadero Los Charcos De Mallarino"));
        listaLugares.add(new ElementoTuristico(
                R.drawable.parque_principal,
                "Parque Principal",
                getString(R.string.parqueDescripcion),
                "",
                "Dirección: El parque principal"));
        listaLugares.add(new ElementoTuristico(
                R.drawable.preventorio_lugar1,
                "Parque Recreativo Ruben Piedrahita Arango",
                getString(R.string.preventorioDescripcion),
                "",
                "Dirección: El preventorio"));
        listaLugares.add(new ElementoTuristico(
                R.drawable.coliseo_lugar1,
                "El coliseo del café",
                getString(R.string.coliseoDescipcion),
                "",
                "Dirección: Calle. 12 #23-46"));
    }
}