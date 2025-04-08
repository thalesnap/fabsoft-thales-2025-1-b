package br.univille.projfabsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.projfabsoft.entity.Musica;

public interface MusicaRepository 
    extends JpaRepository<Musica, Long> {
    

}
