package com.example.turismoyarumal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Locale;

public class DetalleLugar extends AppCompatActivity {
    /**
     * Clase que nos ayudara a mostrar informacion mas detallada de cada uno de los lugares turisticos de la app
     * XML:activity_detalle_lugar.xml
     */
    TextView tituloDetalle,descripcionDetalle, contactoDetalle, direccionDetalle;
    ImageView imagenDetalle;
    LugarTuristico lugarDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_lugar);

        tituloDetalle = findViewById(R.id.tvTituloDetalleLugar);
        descripcionDetalle = findViewById(R.id.tvDescripcionDetalle);
        contactoDetalle = findViewById(R.id.tvContactoDetalle);
        direccionDetalle = findViewById(R.id.tvDireccionDetalle);
        imagenDetalle = findViewById(R.id.ivImagenDetalle);

        lugarDetalle = (LugarTuristico) getIntent().getSerializableExtra("detalleLugar");

        tituloDetalle.setText(lugarDetalle.getTituloElemento());
        descripcionDetalle.setText(lugarDetalle.getDescripcionElemento());
        contactoDetalle.setText(lugarDetalle.getContacto());
        direccionDetalle.setText(lugarDetalle.getDireccion());
        Picasso.with(this).load(lugarDetalle.getImagenElemento())
                .into(imagenDetalle);
        //imagenDetalle.setImageResource(lugarDetalle.getImagenElemento());
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
                Intent intent1 = new Intent(DetalleLugar.this, DetalleLugar.class);
                startActivity(intent1);
                break;
            case(R.id.opcion2):
                cambiarIdioma("es");
                Intent intent2 = new Intent(DetalleLugar.this, DetalleLugar.class);
                startActivity(intent2);
                break;
            case (R.id.opcion3):
                Intent intent3 = new Intent(DetalleLugar.this,Contribuir.class);
                startActivity(intent3);
                break;
            case(R.id.opcion4):
                Intent intent4 = new Intent(DetalleLugar.this,AcercaDe.class);
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