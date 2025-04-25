package br.senac.com.ProjetoIntegradorBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.com.ProjetoIntegradorBackend.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
