package br.univille.projfabsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.projfabsoft.entity.Playlist;

public interface PlaylistRepository 
    extends JpaRepository<Playlist, Long> {

}
