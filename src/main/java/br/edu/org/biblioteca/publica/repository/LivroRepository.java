package br.edu.org.biblioteca.publica.repository;

import br.edu.org.biblioteca.publica.domain.dto.LivroLowDTO;
import br.edu.org.biblioteca.publica.domain.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

//    @Query("SELECT li FROM Livro li JOIN FETCH li.categoria c WHERE LOWER(c.nome) = LOWER(:nome)")
//    List<Livro> findByCategoriaNome(@Param("nome") String nome);
//
  Optional<Livro> findByTitulo(String titulo);
}
