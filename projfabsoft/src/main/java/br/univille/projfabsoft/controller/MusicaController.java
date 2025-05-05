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

    @PutMapping("/{id}")
    public ResponseEntity<Musica> updateMusica(@PathVariable Long id, @RequestBody Musica musica) {
        var existingMusica = service.getById(id);
        if (existingMusica == null) {
            return ResponseEntity.notFound().build();
        }
        musica.setId(id); // Garante que o ID não será alterado
        service.save(musica);
        return new ResponseEntity<>(musica, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusica(@PathVariable Long id) {
        var existingMusica = service.getById(id);
        if (existingMusica == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}