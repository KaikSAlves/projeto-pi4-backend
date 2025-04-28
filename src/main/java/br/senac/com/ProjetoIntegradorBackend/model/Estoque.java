package br.senac.com.ProjetoIntegradorBackend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_estoque")
public class Estoque {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id_estoque")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @Column(name = "qtd_disponivel")
    private int qtdDisponivel;

    @Column(name = "qtd_min", nullable = false)
    private int qtdMinima;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    public Estoque(Produto produto, int qtdDisponivel, int qtdMinima, LocalDateTime data) {
        this.produto = produto;
        this.qtdDisponivel = qtdDisponivel;
        this.qtdMinima = qtdMinima;
        this.dataAtualizacao = data;
    }

}
