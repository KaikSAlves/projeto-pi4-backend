package br.senac.com.ProjetoIntegradorBackend.controller;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.senac.com.ProjetoIntegradorBackend.model.Usuario;
import br.senac.com.ProjetoIntegradorBackend.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RequestMapping("/usuario")
@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioService s;

    //post

    @PostMapping
    public ResponseEntity<Usuario> salvar (@RequestBody Usuario u) {
        u = s.save(u);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(u.getId()).toUri();
        return ResponseEntity.created(uri).body(u);
    }

    //gets

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> pegarPorId(@PathVariable Integer id) {
        Usuario u = s.findById(id);

        return ResponseEntity.ok().body(u);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> pegarTodos() {
        List<Usuario> usuarios = s.findAll();

        return ResponseEntity.ok().body(usuarios);
    }

    //put

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario u) {
        u = s.update(id, u);
        return ResponseEntity.ok().body(u);
    }

    //delete

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id){
        s.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    
    
}
