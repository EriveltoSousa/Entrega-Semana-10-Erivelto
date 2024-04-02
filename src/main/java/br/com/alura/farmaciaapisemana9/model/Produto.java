package br.com.alura.farmaciaapisemana9.model;

import br.com.alura.farmaciaapisemana9.DTO.DadosCadastroDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public Object getFabricante() {
    }

    public void getNome() {
    }

    public void getdescricao() {
    }

    public void getpreco() {

    }

    public Object getId() {
    }
}
