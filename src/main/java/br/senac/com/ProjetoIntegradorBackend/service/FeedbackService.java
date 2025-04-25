package br.senac.com.ProjetoIntegradorBackend.service;

import java.util.List;

import org.hibernate.boot.query.FetchDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.com.ProjetoIntegradorBackend.model.Feedback;
import br.senac.com.ProjetoIntegradorBackend.repository.FeedbackRepository;

@Service
public class FeedbackService {
    
    @Autowired
    private FeedbackRepository r;

    //create

    public Feedback save(Feedback f){
        return r.save(f);
    }

    //read

    public Feedback findById(Integer id){
        return r.findById(id).orElse(null);
    }

    public List<Feedback> findAll(){
        return r.findAll();
    }

    //update

    public Feedback update(Integer id, Feedback f){
        Feedback f1 = r.findById(id).orElse(null);

        updateData(f1, f);

        return r.save(f1);
    }

    private void updateData(Feedback f1, Feedback f){
        f1.setData(f.getData());
        f1.setDescricao(f.getDescricao());
        f1.setNivelAvaliacao(f.getNivelAvaliacao());
    }

    //delete

    public void deleteById(Integer id){
        r.deleteById(id);
    }
}