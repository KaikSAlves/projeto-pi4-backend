package br.senac.com.ProjetoIntegradorBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.com.ProjetoIntegradorBackend.model.Estoque;
import br.senac.com.ProjetoIntegradorBackend.repository.EstoqueRepository;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository r;


    //create

    public Estoque save(Estoque e){
        return r.save(e);
    }

    //read

    public Estoque findById(Integer id){
        return r.findById(id).orElse(null);
    }

    public List<Estoque> findAll(){
        return r.findAll();
    }

    //update

    public Estoque update(Integer id, Estoque e){
        Estoque e1 = r.findById(id).orElse(null);

        updateData(e1, e);

        return r.save(e1);
    }

    private void updateData(Estoque e1, Estoque e){
        e1.setDataAtualizacao(e.getDataAtualizacao());
        e1.setProduto(e.getProduto());
        e1.setQtdDisponivel(e.getQtdDisponivel());
        e1.setQtdMinima(e.getQtdMinima());
    }


    //delete
    public void deleteById(Integer id){
        r.deleteById(id);
    }

}
