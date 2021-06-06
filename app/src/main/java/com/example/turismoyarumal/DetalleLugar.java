package com.example.turismoyarumal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Display;
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
                .resize(1000,950)
                .centerInside()
                .into(imagenDetalle);
        //imagenDetalle.setImageResource(lugarDetalle.getImagenElemento());
    }
}