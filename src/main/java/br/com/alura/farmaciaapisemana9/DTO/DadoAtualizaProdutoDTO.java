package br.com.alura.farmaciaapisemana9.DTO;

import jakarta.validation.constraints.NotNull;

public record DadoAtualizaProdutoDTO(
        @NotNull
        int id,
        String descricaoProduto,
        double precoProduto) {

}
