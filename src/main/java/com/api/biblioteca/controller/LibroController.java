package com.api.biblioteca.controller;

import com.api.biblioteca.dto.LibroDTO;
import com.api.biblioteca.dto.Mensaje;
import com.api.biblioteca.entities.Libro;
import com.api.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/libro")
public class LibroController {

    @Autowired
    LibroService libroService;

    @PostMapping("/createLibro")
    public ResponseEntity<?> createLibro(@RequestBody LibroDTO libroDTO){
        Libro libro = new Libro(libroDTO.getIdAutor(), libroDTO.getNombre(), libroDTO.getDescripcion(), libroDTO.getFechaPublicacion());
        libroService.save(libro);
        return new ResponseEntity(new Mensaje("Libro creado"), HttpStatus.OK);
    }

}
