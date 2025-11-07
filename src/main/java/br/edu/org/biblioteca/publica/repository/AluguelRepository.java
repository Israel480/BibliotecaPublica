package br.edu.org.biblioteca.publica.repository;

import br.edu.org.biblioteca.publica.domain.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

}
