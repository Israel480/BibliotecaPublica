package br.edu.org.biblioteca.publica.repository;


import br.edu.org.biblioteca.publica.domain.model.Revista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevistaRepository extends JpaRepository<Revista, Long> {
}
