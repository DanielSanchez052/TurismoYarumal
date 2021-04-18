package com.example.turismoyarumal;

import java.util.ArrayList;
import java.io.Serializable;

public class ElementoTuristico implements Serializable {

    private int imagenElemento;
    private String tituloElemento;
    private String descripcionElemento="";
    private String contacto="";
    private String direccion;
    private ArrayList<ElementoTuristico> lugaresTuristicos;

    public ElementoTuristico(int imagenElemento, String tituloElemento) {
        this.imagenElemento = imagenElemento;
        this.tituloElemento = tituloElemento;
    }

    public ElementoTuristico(int imagenElemento, String tituloElemento,ArrayList<ElementoTuristico> lugaresTuristicos) {
        this.imagenElemento = imagenElemento;
        this.tituloElemento = tituloElemento;
        this.lugaresTuristicos = lugaresTuristicos;

    }

    public ElementoTuristico(int imagenElemento, String tituloElemento, String descripcionElemento, String contacto, String direccion) {
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
