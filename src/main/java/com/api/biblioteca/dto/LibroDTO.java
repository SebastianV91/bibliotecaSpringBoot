package com.api.biblioteca.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class LibroDTO {

    private int idAutor;
    private String nombre;
    private String descripcion;
    private Date fechaPublicacion;

    public LibroDTO() {
    }

    public LibroDTO(int idAutor, String nombre, String descripcion, Date fechaPublicacion) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

}
