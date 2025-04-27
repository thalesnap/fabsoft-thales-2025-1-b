package br.univille.projfabsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}