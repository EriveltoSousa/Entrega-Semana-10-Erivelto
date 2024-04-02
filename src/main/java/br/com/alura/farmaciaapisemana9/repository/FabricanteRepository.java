package br.com.alura.farmaciaapisemana9.repository;

import br.com.alura.farmaciaapisemana9.model.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {
    Fabricante findByNome(String s);
}
