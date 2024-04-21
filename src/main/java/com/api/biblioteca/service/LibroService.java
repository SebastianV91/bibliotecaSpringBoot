package com.api.biblioteca.service;

import com.api.biblioteca.entities.Libro;

import java.util.List;

public interface LibroService {

    public void save(Libro libro);

    public List<Libro> list();

}
