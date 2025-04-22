package br.univille.projfabsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft.entity.Usuario;
import br.univille.projfabsoft.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios(){
        var listaUsuarios = service.findAll();

        return new ResponseEntity<List<Usuario>>(listaUsuarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario Usuario){
        if(Usuario == null){
            return ResponseEntity.badRequest().build();
        }
        if(Usuario.getId() == 0){
            service.save(Usuario);
            return new ResponseEntity<Usuario>(Usuario, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> 
        putUsuario(@PathVariable long id, @RequestBody Usuario usuario){

        if(id <= 0 || usuario == null){
            return ResponseEntity.badRequest().build();
        }
        var usuarioAntigo = service.findById(id);
        if(usuarioAntigo == null){
            return ResponseEntity.notFound().build();
        }
        usuarioAntigo.setNome(usuario.getNome());
        usuarioAntigo.setEmail(usuario.getEmail());
        usuarioAntigo.setSenha(usuario.getSenha());
        
        service.save(usuarioAntigo);
        return new ResponseEntity<Usuario>(usuarioAntigo, HttpStatus.OK);

    }

    public ResponseEntity<Usuario> deleteUsuario(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }

        var usuarioExcluido = service.findById(id);
        if(usuarioExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        
        return new ResponseEntity<Usuario>(usuarioExcluido, HttpStatus.OK)

    }


}
