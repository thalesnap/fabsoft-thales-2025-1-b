package br.univille.projfabsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.projfabsoft.entity.Genero;

public interface GeneroRepository
    extends JpaRepository<Genero, Long> {

}
