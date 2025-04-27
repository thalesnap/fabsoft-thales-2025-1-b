package br.univille.projfabsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.univille.projfabsoft.entity.Playlist;
import br.univille.projfabsoft.service.PlaylistService;

@RestController
@RequestMapping("/api/v1/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService service;

    @GetMapping
    public ResponseEntity<List<Playlist>> getPlaylists() {
        var listaPlaylists = service.getAll();
        return new ResponseEntity<>(listaPlaylists, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Playlist> postPlaylist(@RequestBody Playlist playlist) {
        if (playlist == null) {
            return ResponseEntity.badRequest().build();
        }
        if (playlist.getId() == 0) {
            service.save(playlist);
            return new ResponseEntity<>(playlist, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}