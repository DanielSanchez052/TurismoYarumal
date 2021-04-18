package com.example.turismoyarumal;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.viewHolder> {
    /**
     * Adaptador que nos ayuda a administrar la informacion que se mostrara en el RecyclerView de la actividad principal
     * que mostrará los grupos de lugares(Hoteles,Comida...) de la app
     */
    ArrayList<ElementoTuristico> listaDatos;

    public AdaptadorLista(ArrayList<ElementoTuristico> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaListado = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,null,false);

        return new viewHolder(vistaListado);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.actualizarDatosItem(listaDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        /**
         * Clase que se utiliza para actualizar la informacion de cada elemento de el RecyclerView
         */
        TextView tituloElemento;
        ImageView imagenElemento;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tituloElemento = itemView.findViewById(R.id.tvTitulo);
            imagenElemento = itemView.findViewById(R.id.ivImagenElemento);
        }

        public void actualizarDatosItem(final ElementoTuristico datosItem){
            tituloElemento.setText(datosItem.getTituloElemento());
            imagenElemento.setImageResource(datosItem.getImagenElemento());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(datosItem.getLugaresTuristicos() != null) {
                        Intent intent = new Intent(itemView.getContext(), ListadoLugares.class);
                        intent.putExtra("lugares", datosItem);
                        itemView.getContext().startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(itemView.getContext(),AcercaDe.class);
                        itemView.getContext().startActivity(intent);
                    }
                }
            });
        }
    }
}