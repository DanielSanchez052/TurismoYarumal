package com.example.turismoyarumal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

public class ListadoHoteles extends AppCompatActivity {
    /**
     * Clase que me ayuda con el RecyclerView que me muestra los lugares individuales de la app
     * XML: activity_listado_hoteles.xml
     */
    RecyclerView listadoLugares;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayList<LugarTuristico> listadoHoteles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_hoteles);

        listadoLugares = findViewById(R.id.rvListadoDetalle);

        getLugares();
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
                Intent intent1 = new Intent(ListadoHoteles.this, ListadoHoteles.class);
                startActivity(intent1);
                break;
            case(R.id.opcion2):
                cambiarIdioma("es");
                Intent intent2 = new Intent(ListadoHoteles.this, ListadoHoteles.class);
                startActivity(intent2);
                break;
            case (R.id.opcion3):
                Intent intent3 = new Intent(ListadoHoteles.this,Contribuir.class);
                startActivity(intent3);
                break;
            case(R.id.opcion4):
                Intent intent4 = new Intent(ListadoHoteles.this,AcercaDe.class);
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

    private void getLugares(){
        db.collection("LugaresTuristicos")
                .whereEqualTo("TipoLugar","Hotel")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        listadoHoteles.add(new LugarTuristico(
                                document.get("imagen").toString(),
                                document.get("nombre").toString(),
                                document.get("descripcion").toString(),
                                document.get("contacto").toString(),
                                document.get("direccion").toString()
                        ));
                    }
                    listadoLugares.setLayoutManager(new LinearLayoutManager(ListadoHoteles.this, LinearLayoutManager.VERTICAL , false));
                    AdaptadorHoteles adaptador = new AdaptadorHoteles(listadoHoteles);
                    listadoLugares.setAdapter(adaptador);
                } else {

                }
            }
        });
    }

}