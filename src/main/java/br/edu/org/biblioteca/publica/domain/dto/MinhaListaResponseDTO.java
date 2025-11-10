package br.edu.org.biblioteca.publica.domain.dto;

import br.edu.org.biblioteca.publica.domain.model.MinhaLista.StatusLeitura;
import br.edu.org.biblioteca.publica.domain.model.Leitor;
import lombok.*;

@Data
public class MinhaListaResponseDTO {
    private Long id;
    private StatusLeitura status;

    private Long leitorId;

    private Long livroId;
    private String tituloLivro;

}
