package br.univille.projfabsoft.service;

import java.util.List;
import java.util.Optional;

import br.univille.projfabsoft.entity.Genero;

public interface GeneroService {
    List<Genero> findAll();
    Optional<Genero> findById(Long id);
    Genero save(Genero genero);
    void deleteById(Long id);
}