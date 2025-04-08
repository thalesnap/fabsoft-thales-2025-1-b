package br.univille.projfabsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.projfabsoft.entity.Usuario;

public interface UsuarioRepository 
    extends JpaRepository<Usuario, Long> {

}
