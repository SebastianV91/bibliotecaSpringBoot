package com.api.biblioteca.controller;

import com.api.biblioteca.dto.LibroDTO;
import com.api.biblioteca.dto.Mensaje;
import com.api.biblioteca.entities.Libro;
import com.api.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class LibroController {

    @Autowired
    LibroService libroService;

    @PostMapping("/libros")
    public ResponseEntity<?> createLibro(@RequestBody LibroDTO libroDTO){

        if(libroService.existsByNombre(libroDTO.getNombre()))
            return new ResponseEntity(new Mensaje("Ese libro ya existe"), HttpStatus.BAD_REQUEST);

        Libro libro = new Libro(libroDTO.getIdAutor(), libroDTO.getNombre(), libroDTO.getDescripcion(), libroDTO.getFechaPublicacion());
        libroService.save(libro);
        return new ResponseEntity(new Mensaje("Libro creado"), HttpStatus.OK);
    }

    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> listLibros(){
        List<Libro> list = libroService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/libros/{id}")
    public ResponseEntity<Libro> getById(@PathVariable("id") Integer id){

        if(!libroService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);

        Libro libro = libroService.getOne(id).get();
        return new ResponseEntity(libro, HttpStatus.OK);
    }

    @PutMapping("/libros/{id}")
    public ResponseEntity<?> updateLibro(@PathVariable("id") int id, @RequestBody LibroDTO libroDTO){

        if(!libroService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el id registrado"), HttpStatus.NOT_FOUND);
        if(libroService.existsByNombre(libroDTO.getNombre()))
            return new ResponseEntity(new Mensaje("Ese libro ya existe"), HttpStatus.BAD_REQUEST);

        Libro libro = libroService.getOne(id).get();
        libro.setIdAutor(libroDTO.getIdAutor());
        libro.setNombre(libroDTO.getNombre());
        libro.setDescripcion(libroDTO.getDescripcion());
        libro.setFechaPublicacion(libroDTO.getFechaPublicacion());
        libroService.save(libro);
        return new ResponseEntity(new Mensaje("Libro actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/libros/{id}")
    public ResponseEntity<?> deleteLibro(@PathVariable("id") int id){

        if(!libroService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el id registrado"), HttpStatus.NOT_FOUND);

        libroService.delete(id);
        return new ResponseEntity(new Mensaje("Libro eliminado"), HttpStatus.OK);
    }

}
