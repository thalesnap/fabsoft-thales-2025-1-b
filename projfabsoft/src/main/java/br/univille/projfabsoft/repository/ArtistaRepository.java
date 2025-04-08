package br.univille.projfabsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoft.entity.Artista;

@Repository
public interface ArtistaRepository 
    extends JpaRepository<Artista, Long> {
    
}
