package br.univille.projfabsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.univille.projfabsoft.entity.Usuario;
import br.univille.projfabsoft.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        var usuarioEncontrado = usuarioRepository.findAll()
            .stream()
            .filter(u -> u.getEmail().equals(usuario.getEmail()) && u.getSenha().equals(usuario.getSenha()))
            .findFirst();

        if (usuarioEncontrado.isPresent()) {
            return ResponseEntity.ok(usuarioEncontrado.get());
        } else {
            return ResponseEntity.status(401).body("Email ou senha inválidos");
        }
    }
}