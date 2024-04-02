package br.com.alura.farmaciaapisemana9.DTO;

import br.com.alura.farmaciaapisemana9.model.Produto;

public record DadosRetornoDTO(String nomeFabricante, String nomeProduto, String descricaoProduto, double precoProduto){

    public DadosRetornoDTO(Produto produto){
        this(produto.getFabricante()
               produto.getNome(),
               produto.getdescricao(),
               produto.getpreco());


    }

    }
