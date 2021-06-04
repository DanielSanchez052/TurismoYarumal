package com.example.turismoyarumal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

public class ListadoLugares extends AppCompatActivity {
    /**
     * Clase que me ayuda con el RecyclerView que me muestra los lugares individuales de la app
     * XML: activity_listado_lugares.xml
     */
    RecyclerView rvListadoLugares;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayList<LugarTuristico> listadoLugares= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_lugares);

        rvListadoLugares = findViewById(R.id.rvListadoLugares);
        rvListadoLugares.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL , false));
    /*
        listadoLugares = (ArrayList<LugarTuristico>) getIntent().getSerializableExtra("listadoLugares");
        AdaptadorLugares adaptador = new AdaptadorLugares(listadoLugares);
        rvListadoLugares.setAdapter(adaptador);
    */
        getLugares();
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case(R.id.opcion1):
                cambiarIdioma("en");
                Intent intent1 = new Intent(ListadoLugares.this, ListadoLugares.class);
                startActivity(intent1);
                break;
            case(R.id.opcion2):
                cambiarIdioma("es");
                Intent intent2 = new Intent(ListadoLugares.this, ListadoLugares.class);
                startActivity(intent2);
                break;
            case(R.id.opcion3):
                Intent intent4 = new Intent(ListadoLugares.this,AcercaDe.class);
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
                .whereEqualTo("TipoLugar","Interes")
                .whereEqualTo("activo",true)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        listadoLugares.add(new LugarTuristico(
                                document.get("imagen").toString(),
                                document.get("nombre").toString(),
                                getResources().getString(getResources().getIdentifier((String) document.get("descripcion"),"string",getPackageName())),
                                document.get("contacto").toString(),
                                document.get("direccion").toString()
                        ));
                    }
                    rvListadoLugares.setLayoutManager(new LinearLayoutManager(ListadoLugares.this, LinearLayoutManager.VERTICAL , false));
                    AdaptadorLugares adaptador = new AdaptadorLugares(listadoLugares);
                    rvListadoLugares.setAdapter(adaptador);
                } else {

                }
            }
        });
    }
}