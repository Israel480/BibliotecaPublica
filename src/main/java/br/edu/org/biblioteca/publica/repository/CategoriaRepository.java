package br.edu.org.biblioteca.publica.repository;

import br.edu.org.biblioteca.publica.domain.model.Categoria;
import br.edu.org.biblioteca.publica.domain.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNomeIgnoreCase(String nome);

}
