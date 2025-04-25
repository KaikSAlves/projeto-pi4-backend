package br.senac.com.ProjetoIntegradorBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.com.ProjetoIntegradorBackend.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
