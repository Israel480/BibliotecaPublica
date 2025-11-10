package br.edu.org.biblioteca.publica.controller;

import br.edu.org.biblioteca.publica.domain.model.MinhaLista.StatusLeitura; // Usando StatusLeitura dentro da entidade MinhaLista
import br.edu.org.biblioteca.publica.domain.dto.MinhaListaRequestDTO;
import br.edu.org.biblioteca.publica.domain.dto.MinhaListaResponseDTO;
import br.edu.org.biblioteca.publica.service.MinhaListaService; // Injetando o Service com o nome correto
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minhas-listas") // Endpoint base ajustado
public class MinhaListaController {

    // Injeta a instância do Service com o nome correto
    @Autowired
    private MinhaListaService minhaListaService;

    // 1. CREATE/UPDATE (PATCH): Mudar/Definir o status de um livro
    @PatchMapping
    public ResponseEntity<MinhaListaResponseDTO> mudarStatusLivro(@RequestBody @Valid MinhaListaRequestDTO requestDTO) {

        // Chamada correta: usa a instância injetada (minhaListaService)
        MinhaListaResponseDTO listaAtualizada = minhaListaService.mudarStatus(
                requestDTO.getLeitorId(),
                requestDTO.getLivroId(),
                requestDTO.getStatus()
        );
        return ResponseEntity.ok(listaAtualizada);
    }

    // 2. READ: Buscar todos os livros de um leitor com um status específico (por Status)
    @GetMapping("/leitor/{leitorId}/{status}")
    public ResponseEntity<List<MinhaListaResponseDTO>> buscarLivrosPorStatus(
            @PathVariable Long leitorId,
            @PathVariable StatusLeitura status) {

        // Chamada correta: usa a instância injetada
        List<MinhaListaResponseDTO> lista = minhaListaService.buscarPorStatus(leitorId, status);
        return ResponseEntity.ok(lista);
    }

    // 3. READ: Buscar toda a lista de um leitor (todos os status)
    @GetMapping("/leitor/{leitorId}")
    public ResponseEntity<List<MinhaListaResponseDTO>> buscarTodaLista(@PathVariable Long leitorId) {

        // Chamada correta: usa a instância injetada
        List<MinhaListaResponseDTO> todaLista = minhaListaService.buscarTodaLista(leitorId);
        return ResponseEntity.ok(todaLista);
    }

    // 4. DELETE: Remover um livro da lista (limpar o status)
    @DeleteMapping("/leitor/{leitorId}/livro/{livroId}")
    public ResponseEntity<Void> removerLivroDaLista(
            @PathVariable Long leitorId,
            @PathVariable Long livroId) {

        // Chamada correta: usa a instância injetada
        minhaListaService.removerLivroDaLista(leitorId, livroId);
        return ResponseEntity.noContent().build();
    }
}