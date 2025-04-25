package br.senac.com.ProjetoIntegradorBackend.model;

import java.time.LocalDateTime;

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
@Table(name = "tb_feedback")
@Entity
public class Feedback {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id_feedback")
    private Integer id;

    @Column(name = "data_feedback")
    private LocalDateTime data;

    @Column(nullable = false, name = "nvl_avaliacao_feedback")
    private int nivelAvaliacao;

    @Column(name = "descricao_feedback", length = 350)
    private String descricao;

    public Feedback(LocalDateTime data, int nivelAvaliacao, String descricao) {
        this.data = data;
        this.nivelAvaliacao = nivelAvaliacao;
        this.descricao = descricao;
    }

}
