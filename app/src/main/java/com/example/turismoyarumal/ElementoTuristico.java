package com.example.turismoyarumal;

import java.util.ArrayList;
import java.io.Serializable;

public class ElementoTuristico implements Serializable {
    /**
     * CLase que representa los lugares turisticos
     */
    private int imagenElemento;
    private String tituloElemento;
    private String descripcionElemento="";
    private String contacto="";
    private String direccion;
    private ArrayList<ElementoTuristico> lugaresTuristicos;//Este arrayList me ayda a almacenar los lugares turisticos individuales

    public ElementoTuristico(int imagenElemento, String tituloElemento) {
        /**
         * Constructor que me ayuda con la informacion de El acerca De
         */
        this.imagenElemento = imagenElemento;
        this.tituloElemento = tituloElemento;
    }

    public ElementoTuristico(int imagenElemento, String tituloElemento,ArrayList<ElementoTuristico> lugaresTuristicos) {
        /**
         * Constructor que me ayuda con la informacion de los grupos de lugares,
         * @param imagenElemento la imagen que se mostará en el grupo de lugares
         * @param tituloElemento titulo de el grupo de lugares
         * @param lugaresTuristicos lista de lugares individuales de este grupo
          */
        this.imagenElemento = imagenElemento;
        this.tituloElemento = tituloElemento;
        this.lugaresTuristicos = lugaresTuristicos;

    }

    public ElementoTuristico(int imagenElemento, String tituloElemento, String descripcionElemento, String contacto, String direccion) {
        /**
         * Constructor que me ayuda a crear Cada lugar individual de la app
         */
        this.imagenElemento = imagenElemento;
        this.tituloElemento = tituloElemento;
        this.descripcionElemento = descripcionElemento;
        this.contacto = contacto;
        this.direccion = direccion;
    }

    public int getImagenElemento() {
        return imagenElemento;
    }

    public void setImagenElemento(int imagenElemento) {
        this.imagenElemento = imagenElemento;
    }

    public String getTituloElemento() {
        return tituloElemento;
    }

    public void setTituloElemento(String tituloElemento) {
        this.tituloElemento = tituloElemento;
    }

    public String getDescripcionElemento() {
        return descripcionElemento;
    }

    public void setDescripcionElemento(String descripcionElemento) {
        this.descripcionElemento = descripcionElemento;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<ElementoTuristico> getLugaresTuristicos() {
        return lugaresTuristicos;
    }

    public void setLugaresTuristicos(ArrayList<ElementoTuristico> lugaresTuristicos) {
        this.lugaresTuristicos = lugaresTuristicos;
    }

}
