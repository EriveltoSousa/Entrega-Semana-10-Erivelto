package br.com.alura.farmaciaapisemana9.DTO;

import br.com.alura.farmaciaapisemana9.model.Produto;
import jakarta.validation.constraints.NotBlank;

public class DadosRetornoDTO{
    public DadosRetornoDTO(Object nome1, Object descricao, Object preco, Object produtoPreco) {
    }

    public DadosRetornoDTO(Produto produto) {
    }
}

