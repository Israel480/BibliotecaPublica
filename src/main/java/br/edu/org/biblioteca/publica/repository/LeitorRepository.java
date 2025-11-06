package br.edu.org.biblioteca.publica.repository;

import br.edu.org.biblioteca.publica.domain.model.Leitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeitorRepository extends JpaRepository<Leitor, Long> {
}
