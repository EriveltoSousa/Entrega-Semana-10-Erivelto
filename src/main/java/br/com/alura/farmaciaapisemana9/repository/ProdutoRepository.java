package br.com.alura.farmaciaapisemana9.repository;

import br.com.alura.farmaciaapisemana9.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
