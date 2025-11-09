package br.edu.org.biblioteca.publica.repository;
import br.edu.org.biblioteca.publica.domain.model.MinhaLista;
import br.edu.org.biblioteca.publica.domain.model.MinhaLista.StatusLeitura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MinhaListaRepository extends JpaRepository<MinhaLista, Long> {

    // Método READ ESSENCIAL: Buscar o status de um livro específico para um leitor
    Optional<MinhaLista> findByLeitorIdAndLivroId(
            Long leitorId, Long livroId
    );

    // Buscar todos os livros de um leitor com um status específico (ex: "LENDO")
    List<MinhaLista> findByLeitorIdAndStatus(
            Long leitorId, StatusLeitura status
    );

    // Método READ: Buscar todos os livros de um leitor (sua prateleira completa)
    List<MinhaLista> findByLeitorId(
            Long leitorId
    );
}