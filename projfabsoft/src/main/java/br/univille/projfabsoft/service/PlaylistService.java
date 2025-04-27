package br.univille.projfabsoft.service;

import java.util.List;

import br.univille.projfabsoft.entity.Playlist;

public interface PlaylistService {
    Playlist save(Playlist playlist);
    List<Playlist> getAll();
    Playlist getById(Long id);
    Playlist delete(Long id);
}