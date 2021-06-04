package com.example.turismoyarumal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Locale;

public class AcercaDe extends AppCompatActivity {
    /**
    *  clase para que se encarga de la logica de la actividad  Acerca de que nos ayuda a ver mas
     *  información de los creadores de la app
     *  XML: activity_acerca_de.xml
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);


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
                Intent intent1 = new Intent(AcercaDe.this, AcercaDe.class);
                startActivity(intent1);
                break;
            case(R.id.opcion2):
                cambiarIdioma("es");
                Intent intent2 = new Intent(AcercaDe.this, AcercaDe.class);
                startActivity(intent2);
                break;
            case(R.id.opcion3):
                Intent intent4 = new Intent(AcercaDe.this,AcercaDe.class);
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