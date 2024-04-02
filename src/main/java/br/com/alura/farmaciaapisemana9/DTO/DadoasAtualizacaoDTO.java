package br.com.alura.farmaciaapisemana9.DTO;

import jakarta.validation.constraints.NotNull;

public record DadoasAtualizacaoDTO(
        @NotNull
        int id,
        String descricaoProduto,
        double precoProduto) {

}
