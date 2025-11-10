package br.edu.org.biblioteca.publica.controller;

import br.edu.org.biblioteca.publica.domain.model.MinhaLista.StatusLeitura; // Usando StatusLeitura dentro da entidade MinhaLista
import br.edu.org.biblioteca.publica.domain.dto.MinhaListaRequestDTO;
import br.edu.org.biblioteca.publica.domain.dto.MinhaListaResponseDTO;
import br.edu.org.biblioteca.publica.service.MinhaListaService; // Injetando o Service com o nome correto
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/minhas-listas") // Endpoint base ajustado
public class MinhaListaController {

    // Injeta a instância do Service com o nome correto
    @Autowired
    private MinhaListaService minhaListaService;

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

    @GetMapping("/leitor/{leitorId}/{status}")
    public ResponseEntity<List<MinhaListaResponseDTO>> buscarLivrosPorStatus(
            @PathVariable Long leitorId,
            @PathVariable StatusLeitura status) {

        // Chamada correta: usa a instância injetada
        List<MinhaListaResponseDTO> lista = minhaListaService.buscarPorStatus(leitorId, status);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/leitor/{leitorId}")
    public ResponseEntity<List<MinhaListaResponseDTO>> buscarTodaLista(@PathVariable Long leitorId) {

        // Chamada correta: usa a instância injetada
        List<MinhaListaResponseDTO> todaLista = minhaListaService.buscarTodaLista(leitorId);
        return ResponseEntity.ok(todaLista);
    }

    @DeleteMapping("/leitor/{leitorId}/livro/{livroId}")
    public ResponseEntity<Void> removerLivroDaLista(
            @PathVariable Long leitorId,
            @PathVariable Long livroId) {

        // Chamada correta: usa a instância injetada
        minhaListaService.removerLivroDaLista(leitorId, livroId);
        return ResponseEntity.noContent().build();
    }
}