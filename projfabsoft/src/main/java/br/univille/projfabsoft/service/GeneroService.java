package br.univille.projfabsoft.service;

import java.util.List;

import br.univille.projfabsoft.entity.Genero;

public interface GeneroService {
    Genero save(Genero genero);
    List<Genero> getAll();
    Genero getById(Long id);
    Genero delete(Long id);
}