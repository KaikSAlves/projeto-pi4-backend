package br.senac.com.ProjetoIntegradorBackend.config;

import org.springframework.context.annotation.Profile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
       System.out.println("Perfil de teste funcionando");
    }
    
}
