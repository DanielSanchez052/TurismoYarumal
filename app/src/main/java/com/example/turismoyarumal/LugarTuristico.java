package com.example.turismoyarumal;

import java.io.Serializable;

public class LugarTuristico implements Serializable {
    /**
     * CLase que representa los lugares turisticos
     */
    private int imagenElemento;
    private String tituloElemento;
    private String descripcionElemento="";
    private String contacto="";
    private String direccion;

    public LugarTuristico(int imagenElemento, String tituloElemento, String descripcionElemento, String contacto, String direccion) {
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

}
