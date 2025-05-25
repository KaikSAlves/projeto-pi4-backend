package br.senac.com.ProjetoIntegradorBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.com.ProjetoIntegradorBackend.model.Produto;
import br.senac.com.ProjetoIntegradorBackend.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository r;

    //create

    public Produto save(Produto p){
        return r.save(p);
    }

    //read

    public Produto findById(Integer id){
        return r.findById(id).orElse(null);
    }

    public List<Produto> findAll(){
        return r.findAll();
    }

    //update

    public Produto update(Integer id, Produto p){
        Produto p1 = r.findById(id).orElse(null);

        updateData(p1, p);

        return r.save(p1);
    }

    private void updateData(Produto p1, Produto p){
        p1.setDescricao(p.getDescricao());
        p1.setSabor(p.getSabor());
        p1.setTipo(p.getTipo());
        p1.setQuantidade(p.getQuantidade());
        p1.setValor(p.getValor());
    }

    //delete

    public void deleteById(Integer id){
        r.deleteById(id);
    }
}
