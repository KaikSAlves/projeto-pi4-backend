package br.senac.com.ProjetoIntegradorBackend.model.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstoqueDTO {
    private Integer produto;
    private int qtdDisponivel;
    private int qtdMinima;
    private LocalDateTime dataAtualizacao;
}
