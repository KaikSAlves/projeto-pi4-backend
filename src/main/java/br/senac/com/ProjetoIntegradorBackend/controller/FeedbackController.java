package br.senac.com.ProjetoIntegradorBackend.controller;

import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.senac.com.ProjetoIntegradorBackend.model.Feedback;
import br.senac.com.ProjetoIntegradorBackend.service.FeedbackService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    
    @Autowired
    private FeedbackService s;

    //post

    @PostMapping
    public ResponseEntity<Feedback> salvar(@RequestBody Feedback f) {
        f = s.save(f);
        
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(f.getId()).toUri();
        return ResponseEntity.created(uri).body(f);
    }

    //gets

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> buscarPorId(@PathVariable Integer id) {
        Feedback f = s.findById(id);

        return ResponseEntity.ok().body(f);
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> buscarTodos() {
        List<Feedback> feedbacks = s.findAll();

        return ResponseEntity.ok().body(feedbacks);
    }

    //put

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> atualizarFeedback(@PathVariable Integer id, @RequestBody Feedback f) {
        f = s.update(id, f);        
        return ResponseEntity.ok().body(f);
    }

    //delete

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFeedback(@PathVariable Integer id){
       s.deleteById(id); 

       return ResponseEntity.noContent().build();
    }
    
    
}
