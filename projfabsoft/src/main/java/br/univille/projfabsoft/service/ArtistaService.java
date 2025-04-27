package br.univille.projfabsoft.service;

import java.util.List;

import br.univille.projfabsoft.entity.Artista;

public interface ArtistaService {
    Artista save(Artista artista);
    List<Artista> getAll();
    Artista getById(Long id);
    Artista delete(Long id);
}