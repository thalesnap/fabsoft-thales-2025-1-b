package br.univille.projfabsoft.service;

import java.util.List;

import br.univille.projfabsoft.entity.Musica;

public interface MusicaService {
    Musica save(Musica musica);
    List<Musica> getAll();
    Musica getById(Long id);
    Musica delete(Long id);
}