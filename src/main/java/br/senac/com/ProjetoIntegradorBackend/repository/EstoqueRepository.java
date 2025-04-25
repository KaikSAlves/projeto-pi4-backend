package br.senac.com.ProjetoIntegradorBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.com.ProjetoIntegradorBackend.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
    
}
