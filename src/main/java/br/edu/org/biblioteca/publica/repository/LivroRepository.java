package br.edu.org.biblioteca.publica.repository;

import br.edu.org.biblioteca.publica.domain.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
