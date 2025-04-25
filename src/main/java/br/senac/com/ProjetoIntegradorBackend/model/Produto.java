package br.senac.com.ProjetoIntegradorBackend.model;

import br.senac.com.ProjetoIntegradorBackend.model.enums.TipoProduto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_produto")
@Getter
@Setter
@NoArgsConstructor
public abstract class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated
    @Column(length = 100, nullable = false, name = "tipo_produto")
    private TipoProduto tipo;

    @Column(length = 200, nullable = false, name = "sabor_produto")
    private String sabor;

    @Column(length = 350, name = "desc_produto")
    private String descricao;

    @Column(nullable = false, name = "valor_produto")
    private Double valor;

    public Produto(TipoProduto tipo, String sabor, String descricao, Double valor) {
        this.tipo = tipo;
        this.sabor = sabor;
        this.descricao = descricao;
        this.valor = valor;
    }
}
