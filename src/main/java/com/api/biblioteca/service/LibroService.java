package com.api.biblioteca.service;

import com.api.biblioteca.entities.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {

    public void save(Libro libro);

    public List<Libro> list();

    public Optional<Libro> getOne(Integer id);

    public void delete(Integer id);

}
