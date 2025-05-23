package br.senac.com.ProjetoIntegradorBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_usuario")
@Entity
public class Usuario {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(nullable = false, unique = true, length = 100, name = "nm_usuario")
    private String nome;

    @Column(nullable = false, unique = true, length = 250, name = "email_usuario")
    private String email;

    @Column(name = "tel_usuario")
    private String telefone;
    
    @Column(name = "senha_usuario")
    private String senha;

    public Usuario(String nome, String email, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

}
