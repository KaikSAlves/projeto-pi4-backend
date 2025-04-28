package br.senac.com.ProjetoIntegradorBackend.controller;

import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.senac.com.ProjetoIntegradorBackend.model.Estoque;
import br.senac.com.ProjetoIntegradorBackend.model.Feedback;
import br.senac.com.ProjetoIntegradorBackend.model.dto.EstoqueDTO;
import br.senac.com.ProjetoIntegradorBackend.service.EstoqueService;
import br.senac.com.ProjetoIntegradorBackend.service.FeedbackService;
import br.senac.com.ProjetoIntegradorBackend.service.ProdutoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RequestMapping("/estoque")
@RestController
public class EstoqueController {
    
    @Autowired
    private EstoqueService s;

    @Autowired
    private ProdutoService pS;

    //post

    @PostMapping
    public ResponseEntity<Estoque> salvar(@RequestBody EstoqueDTO dto) {
        Estoque e = new Estoque();
        e.setDataAtualizacao(dto.getDataAtualizacao());
        e.setProduto(pS.findById(dto.getProduto()));
        e.setQtdDisponivel(dto.getQtdDisponivel());
        e.setQtdMinima(dto.getQtdMinima());
        
        e = s.save(e);
        
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(e.getId()).toUri();
        return ResponseEntity.created(uri).body(e);
    }
    
    //gets

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> buscarPorId(@PathVariable Integer id) {
        Estoque e = s.findById(id);

        return ResponseEntity.ok().body(e);
    }

    @GetMapping
    public ResponseEntity<List<Estoque>> buscarTodos() {
        List<Estoque> estoques = s.findAll();

        return ResponseEntity.ok().body(estoques);
    }

    //put

    @PutMapping("/{id}")
    public ResponseEntity<Estoque> atualizarEstoque(@PathVariable Integer id, @RequestBody EstoqueDTO dto) {
        Estoque e = new Estoque();
        e.setDataAtualizacao(dto.getDataAtualizacao());
        e.setProduto(pS.findById(dto.getProduto()));
        e.setQtdDisponivel(dto.getQtdDisponivel());
        e.setQtdMinima(dto.getQtdMinima());
        
        e = s.update(id, e);
        
        return ResponseEntity.ok().body(e);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEstoque(@PathVariable Integer id){
        s.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    
    
}
