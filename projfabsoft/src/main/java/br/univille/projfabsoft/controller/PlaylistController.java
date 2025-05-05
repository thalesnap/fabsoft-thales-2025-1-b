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

    @PutMapping("/{id}")
public ResponseEntity<Playlist> updatePlaylist(@PathVariable Long id, @RequestBody Playlist playlist) {
    var existingPlaylist = service.getById(id);
    if (existingPlaylist == null) {
        return ResponseEntity.notFound().build();
    }
    playlist.setId(id); // Garante que o ID não será alterado
    service.save(playlist);
    return new ResponseEntity<>(playlist, HttpStatus.OK);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
    var existingPlaylist = service.getById(id);
    if (existingPlaylist == null) {
        return ResponseEntity.notFound().build();
    }
    service.delete(id);
    return ResponseEntity.noContent().build();
}

}