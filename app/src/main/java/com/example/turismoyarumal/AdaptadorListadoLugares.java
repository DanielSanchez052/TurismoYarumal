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

public class AdaptadorListadoLugares extends RecyclerView.Adapter<AdaptadorListadoLugares.viewHolder> {
    /**
     * Adaptador que nos ayuda a administrar la informacion que se mostrara en el RecyclerView de la actividad que mostrará
     * cada uno de los lugares turisticos de la aplicacion
     */
    ArrayList<ElementoTuristico> listaDatos;

    public AdaptadorListadoLugares(ArrayList<ElementoTuristico> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaListado = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_listado_lugares,null,false);

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

        TextView tituloDetalle,descripcionDetalle;
        ImageView imagenDetalle;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tituloDetalle = itemView.findViewById(R.id.tvTituloLugar);
            imagenDetalle = itemView.findViewById(R.id.ivImagenLugar);
            descripcionDetalle =itemView.findViewById(R.id.tvDescripcionLugar);
        }

        public void actualizarDatosItem(final ElementoTuristico datosItem){
            tituloDetalle.setText(datosItem.getTituloElemento());
            imagenDetalle.setImageResource(datosItem.getImagenElemento());
            descripcionDetalle.setText(datosItem.getDescripcionElemento());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), DetalleLugar.class);
                    intent.putExtra("detalleLugar", datosItem);
                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }
}
