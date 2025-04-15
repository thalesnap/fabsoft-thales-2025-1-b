package br.univille.projfabsoft.service;

import java.util.List;
import java.util.Optional;

import br.univille.projfabsoft.entity.Artista;

public interface ArtistaService {
    List<Artista> findAll();
    Optional<Artista> findById(Long id);
    Artista save(Artista artista);
    void deleteById(Long id);
}