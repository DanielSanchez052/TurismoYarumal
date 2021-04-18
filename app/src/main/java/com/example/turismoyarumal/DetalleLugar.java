package com.example.turismoyarumal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleLugar extends AppCompatActivity {
    TextView tituloDetalle,descripcionDetalle, contactoDetalle, direccionDetalle;
    ImageView imagenDetalle;
    ElementoTuristico lugarDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_lugar);

        tituloDetalle = findViewById(R.id.tvTituloDetalleLugar);
        descripcionDetalle = findViewById(R.id.tvDescripcionDetalle);
        contactoDetalle = findViewById(R.id.tvContactoDetalle);
        direccionDetalle = findViewById(R.id.tvDireccionDetalle);
        imagenDetalle = findViewById(R.id.ivImagenDetalle);

        lugarDetalle = (ElementoTuristico) getIntent().getSerializableExtra("detalleLugar");

        tituloDetalle.setText(lugarDetalle.getTituloElemento());
        descripcionDetalle.setText(lugarDetalle.getDescripcionElemento());
        contactoDetalle.setText(lugarDetalle.getContacto());
        direccionDetalle.setText(lugarDetalle.getDireccion());
        imagenDetalle.setImageResource(lugarDetalle.getImagenElemento());
    }
}