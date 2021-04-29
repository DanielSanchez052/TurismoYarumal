package com.example.turismoyarumal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class  MainActivity extends AppCompatActivity {
    CardView itemMainHoteles;
    CardView itemMainLugares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemMainHoteles = findViewById(R.id.itemMainHoteles);
        itemMainLugares = findViewById(R.id.itemMainLugares);



    }
}