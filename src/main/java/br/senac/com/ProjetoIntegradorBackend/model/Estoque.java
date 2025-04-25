package br.senac.com.ProjetoIntegradorBackend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_estoque")
@Getter
@Setter
@NoArgsConstructor
public class Estoque {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "produto_estoque", nullable = false)
    private Produto produto;

    @Column(name = "qtd_disponivel")
    private int qtdDisponivel;

    @Column(name = "qtd_min", nullable = false)
    private int qtdMinima;

    @Column(name = "data_atualizacao")
    private LocalDateTime data;

    public Estoque(Produto produto, int qtdDisponivel, int qtdMinima, LocalDateTime data) {
        this.produto = produto;
        this.qtdDisponivel = qtdDisponivel;
        this.qtdMinima = qtdMinima;
        this.data = data;
    }

}
