package br.senac.com.ProjetoIntegradorBackend.config;

import org.springframework.context.annotation.Profile;

import br.senac.com.ProjetoIntegradorBackend.model.Usuario;
import br.senac.com.ProjetoIntegradorBackend.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner{

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(String... args) throws Exception {
       usuarioService.save(new Usuario("admin", "admin@gmail.com", "1199999999", "admin123"));
    }
    
}
