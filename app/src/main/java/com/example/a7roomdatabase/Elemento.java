package com.example.a7roomdatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Elemento {
    @PrimaryKey(autoGenerate = true)
    int id;

    String nombre;
    String descripcion;
    String tipos;
    int imagen;
    float valoracion;

    public Elemento(int imagen,String nombre, String tipos,String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.tipos = tipos;

    }
}
