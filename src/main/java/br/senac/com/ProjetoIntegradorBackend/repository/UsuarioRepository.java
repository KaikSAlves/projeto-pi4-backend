package br.senac.com.ProjetoIntegradorBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.com.ProjetoIntegradorBackend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
