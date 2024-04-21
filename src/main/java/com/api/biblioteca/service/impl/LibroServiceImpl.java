package com.api.biblioteca.service.impl;

import com.api.biblioteca.entities.Libro;
import com.api.biblioteca.repository.LibroRepository;
import com.api.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    LibroRepository libroRepository;

    @Override
    public void save(Libro libro) {
        libroRepository.save(libro);
    }

    @Override
    public List<Libro> list() {
        return libroRepository.findAll();
    }

    @Override
    public Optional<Libro> getOne(Integer id) {
        return libroRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        libroRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return libroRepository.existsById(id);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return libroRepository.existsByNombre(nombre);
    }


}
