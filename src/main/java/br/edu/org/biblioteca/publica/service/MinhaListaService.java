package br.edu.org.biblioteca.publica.service;

import br.edu.org.biblioteca.publica.domain.model.MinhaLista;
import br.edu.org.biblioteca.publica.domain.model.Leitor;
import br.edu.org.biblioteca.publica.domain.model.MinhaLista;
import br.edu.org.biblioteca.publica.domain.model.MinhaLista.StatusLeitura;
import br.edu.org.biblioteca.publica.domain.dto.MinhaListaRequestDTO;
import br.edu.org.biblioteca.publica.domain.dto.MinhaListaResponseDTO;
import br.edu.org.biblioteca.publica.exception.ApiException;
import br.edu.org.biblioteca.publica.repository.MinhaListaRepository;
import br.edu.org.biblioteca.publica.repository.LeitorRepository;
import br.edu.org.biblioteca.publica.repository.LivroRepository;
import br.edu.org.biblioteca.publica.util.MapperUtil; // Uso do MapperUtil
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinhaListaService {

    // Repositórios injetados para acesso a dados
    @Autowired
    private MinhaListaRepository repository;

    @Autowired
    private LeitorRepository leitorRepository;

    @Autowired
    private LivroRepository livroRepository;

    /**
     * CREATE / UPDATE: Adiciona ou atualiza o status de um livro na lista do leitor.
     */
    public MinhaListaResponseDTO mudarStatus(Long leitorId, Long livroId, StatusLeitura novoStatus) {

        // 1. Tenta buscar o registro existente (UPDATE)
        var listaOpt = repository.findByLeitorIdAndLivroId(leitorId, livroId);

        MinhaLista lista;

        if (listaOpt.isPresent()) {
            // Caso 1: REGISTRO EXISTE (UPDATE)
            lista = listaOpt.get();
        } else {
            // Caso 2: REGISTRO NÃO EXISTE (CREATE)

            // Busca e valida a existência das entidades relacionadas
            var leitor = leitorRepository.findById(leitorId).orElseThrow(
                    () -> new ApiException(HttpStatus.NOT_FOUND,
                            "minhalista.service.leitor.notfound",
                            "Leitor não encontrado.")
            );

            var livro = livroRepository.findById(livroId).orElseThrow(
                    () -> new ApiException(HttpStatus.NOT_FOUND,
                            "minhalista.service.livro.notfound",
                            "Livro não encontrado.")
            );

            // Cria um novo registro
            lista = new MinhaLista();
            lista.setLeitor(leitor);
            lista.setLivro(livro);
        }

        // 3. Aplica o novo status e salva
        lista.setStatus(novoStatus);
        var listaSalva = repository.save(lista);

        // 4. Retorna o DTO de Resposta
        // NOTA: O MapperUtil precisará ser atualizado para mapear as informações de Leitor e Livro
        // para o MinhaListaResponseDTO (campos como nomeLeitor, tituloLivro).
        return MapperUtil.parseObject(listaSalva, MinhaListaResponseDTO.class);
    }

    /**
     * READ: Busca todos os livros de um leitor com um status específico.
     */
    public List<MinhaListaResponseDTO> buscarPorStatus(Long leitorId, StatusLeitura status) {

        var listas = repository.findByLeitorIdAndStatus(leitorId, status);

        if (listas.isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND,
                    "minhalista.service.status.notfound",
                    "Nenhum livro encontrado com este status para o leitor.");
        }

        // Converte a lista de Entidades para lista de DTOs
        return MapperUtil.parseListObjects(listas, MinhaListaResponseDTO.class);
    }

    /**
     * READ: Busca toda a lista de um leitor (todos os status).
     */
    public List<MinhaListaResponseDTO> buscarTodaLista(Long leitorId) {

        var todaLista = repository.findByLeitorId(leitorId);

        if (todaLista.isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND,
                    "minhalista.service.lista.vazia",
                    "O leitor não possui livros cadastrados em sua lista.");
        }

        // Converte a lista de Entidades para lista de DTOs
        return MapperUtil.parseListObjects(todaLista, MinhaListaResponseDTO.class);
    }

    /**
     * DELETE: Remove um livro da lista do leitor.
     */
    public void removerLivroDaLista(Long leitorId, Long livroId) {

        // Busca o registro específico usando o método do Repository
        var lista = repository.findByLeitorIdAndLivroId(leitorId, livroId).orElseThrow(
                () -> new ApiException(HttpStatus.NOT_FOUND,
                        "minhalista.service.delete.notfound",
                        "Livro não encontrado na lista do leitor para remoção.")
        );

        // Deleta o registro encontrado
        repository.delete(lista);
    }
}