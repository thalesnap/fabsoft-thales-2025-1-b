package br.univille.projfabsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft.entity.Genero;
import br.univille.projfabsoft.service.GeneroService;

@RestController
@RequestMapping("/api/v1/generos")
public class GeneroController {

    @Autowired
    private GeneroService service;

    @GetMapping
    public ResponseEntity<List<Genero>> getGeneros() {
        var listaGeneros = service.getAll();
        return new ResponseEntity<>(listaGeneros, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Genero> postGenero(@RequestBody Genero genero) {
        if (genero == null) {
            return ResponseEntity.badRequest().build();
        }
        if (genero.getId() == 0) {
            service.save(genero);
            return new ResponseEntity<>(genero, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Genero> updateGenero(@PathVariable Long id, @RequestBody Genero genero) {
        var existingGenero = service.getById(id);
        if (existingGenero == null) {
            return ResponseEntity.notFound().build();
        }
        genero.setId(id); // Garante que o ID não será alterado
        service.save(genero);
        return new ResponseEntity<>(genero, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenero(@PathVariable Long id) {
        var existingGenero = service.getById(id);
        if (existingGenero == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}