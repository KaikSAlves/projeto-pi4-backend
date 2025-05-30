package br.senac.com.ProjetoIntegradorBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
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
@Entity
@Table(name = "tb_produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id_produto")
    private Integer id;

    @Column(length = 100, nullable = false, name = "tipo_produto")
    private String tipo;

    @Column(length = 200, nullable = false, name = "sabor_produto")
    private String sabor;

    @Column(length = 350, name = "desc_produto")
    private String descricao;

    @Column(nullable = false, name = "qtd_estoque")
    private Integer quantidade;

    @Column(nullable = false, name = "valor_produto")
    private Double valor;

    public Produto(String tipo, String sabor, String descricao, Double valor, Integer quantidadeEstoque) {
        this.quantidade = quantidadeEstoque;
        this.tipo = tipo;
        this.sabor = sabor;
        this.descricao = descricao;
        this.valor = valor;
    }
}
