package br.univille.projfabsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.univille.projfabsoft.entity.Musica;
import br.univille.projfabsoft.service.MusicaService;

@RestController
@RequestMapping("/api/v1/musicas")
public class MusicaController {

    @Autowired
    private MusicaService service;

    @GetMapping
    public ResponseEntity<List<Musica>> getMusicas() {
        var listaMusicas = service.getAll();
        return new ResponseEntity<>(listaMusicas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Musica> postMusica(@RequestBody Musica musica) {
        if (musica == null) {
            return ResponseEntity.badRequest().build();
        }
        if (musica.getId() == 0) {
            service.save(musica);
            return new ResponseEntity<>(musica, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}