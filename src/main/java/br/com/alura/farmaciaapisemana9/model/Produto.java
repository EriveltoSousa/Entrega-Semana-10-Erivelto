package br.com.alura.farmaciaapisemana9.model;

import br.com.alura.farmaciaapisemana9.DTO.DadoasAtualizacaoDTO;
import br.com.alura.farmaciaapisemana9.DTO.DadosCadastroDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Table(name ="produtos")
@Entity(name ="produtos")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    @ManyToOne
    private Fabricante fabricante;

    public Produto(DadosCadastroDTO dadosCadastro, Fabricante fabricante) {
        this.nome = dadosCadastro.nomeProduto();
        this.descricao = dadosCadastro.descricaoProduto();
        this.preco = dadosCadastro.precoProduto();
        this.fabricante = fabricante;

    }

    public void getFabricante() {
    }

    public void getNome() {
    }

    public void getdescricao() {
    }

    public void getpreco() {

    }

    public Map<String, ?> getId() {
        return null;
    }

    public void atualizar(DadoasAtualizacaoDTO produtoDTO) {
        if (produtoDTO.descricaoProduto() != null) {
            this.descricao = produtoDTO.descricaoProduto();
        }
        if (produtoDTO.precoProduto() > 0 ){
            this.preco = produtoDTO.precoProduto();
        }
    }
}
