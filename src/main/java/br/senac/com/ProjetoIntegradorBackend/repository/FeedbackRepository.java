package br.senac.com.ProjetoIntegradorBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.com.ProjetoIntegradorBackend.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{
    
}
