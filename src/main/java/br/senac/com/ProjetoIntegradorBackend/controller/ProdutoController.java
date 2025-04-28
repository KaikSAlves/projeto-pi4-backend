package br.senac.com.ProjetoIntegradorBackend.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.senac.com.ProjetoIntegradorBackend.model.Produto;
import br.senac.com.ProjetoIntegradorBackend.service.ProdutoService;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RequestMapping("/produto")
@RestController
public class ProdutoController {
    
    @Autowired
    private ProdutoService s;


    //post

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto p) {
        p = s.save(p);

          URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(uri).body(p);
    }

    //gets

    @GetMapping("/{id}")
    public ResponseEntity<Produto> pegarPorId(@PathVariable Integer id) {
        Produto p  = s.findById(id);

        return ResponseEntity.ok().body(p);
    }


    @GetMapping
    public ResponseEntity<List<Produto>> pegarTodos() {
        List<Produto> produtos = s.findAll();

        return ResponseEntity.ok().body(produtos);
    }
    
    //put

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Integer id, @RequestBody Produto p) {
        p = s.update(id, p);

        return ResponseEntity.ok().body(p) ;
    }

    //delete

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer id){
        s.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    
}
