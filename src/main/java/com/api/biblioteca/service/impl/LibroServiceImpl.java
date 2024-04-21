package com.api.biblioteca.service.impl;

import com.api.biblioteca.entities.Libro;
import com.api.biblioteca.repository.LibroRepository;
import com.api.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
