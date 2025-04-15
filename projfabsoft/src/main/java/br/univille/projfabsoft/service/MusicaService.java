package br.univille.projfabsoft.service;

import java.util.List;
import java.util.Optional;

import br.univille.projfabsoft.entity.Musica;

public interface MusicaService {
    List<Musica> findAll();
    Optional<Musica> findById(Long id);
    Musica save(Musica musica);
    void deleteById(Long id);
}