package br.univille.projfabsoft.service;

import java.util.List;
import java.util.Optional;

import br.univille.projfabsoft.entity.Playlist;

public interface PlaylistService {
    List<Playlist> findAll();
    Optional<Playlist> findById(Long id);
    Playlist save(Playlist playlist);
    void deleteById(Long id);
}