package br.univille.projfabsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.univille.projfabsoft.entity.Musica;
import br.univille.projfabsoft.service.MusicaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/musicas")
public class MusicaController {
    private static final Logger logger = LoggerFactory.getLogger(MusicaController.class);

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
            logger.error("Corpo da requisição nulo");
            return ResponseEntity.badRequest().build();
        }
        logger.info("Recebendo música: nome={}, urlArquivo={}", musica.getNome(), musica.getUrlArquivo());
        try {
            service.save(musica);
            return new ResponseEntity<>(musica, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Erro ao salvar música: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> updateMusica(@PathVariable Long id, @RequestBody Musica musica) {
        var existingMusica = service.getById(id);
        if (existingMusica == null) {
            return ResponseEntity.notFound().build();
        }
        musica.setId(id);
        logger.info("Atualizando música: nome={}, urlArquivo={}", musica.getNome(), musica.getUrlArquivo());
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