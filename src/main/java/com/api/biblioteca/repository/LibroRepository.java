package com.api.biblioteca.repository;

import com.api.biblioteca.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
    boolean existsByNombre(String nombre);
}
