package br.univille.projfabsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft.entity.Artista;
import br.univille.projfabsoft.service.ArtistaService;

@RestController
@RequestMapping("/api/v1/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService service;

    @GetMapping
    public ResponseEntity<List<Artista>> getArtistas() {
        var listaArtistas = service.getAll();
        return new ResponseEntity<>(listaArtistas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Artista> postArtista(@RequestBody Artista artista) {
        if (artista == null) {
            return ResponseEntity.badRequest().build();
        }
        if (artista.getId() == 0) {
            service.save(artista);
            return new ResponseEntity<>(artista, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}