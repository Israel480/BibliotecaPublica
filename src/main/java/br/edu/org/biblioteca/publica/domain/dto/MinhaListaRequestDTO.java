package br.edu.org.biblioteca.publica.domain.dto;

import br.edu.org.biblioteca.publica.domain.model.MinhaLista.StatusLeitura;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class MinhaListaRequestDTO {
    @NotNull(message = "o ID do livro é obirgatorio")
    private long leitorId;

    @NotNull(message = "O ID do livro é obrigatório.")
    private Long livroId;

    @NotNull(message = "O status de leitura é obrigatório.")
    private StatusLeitura status;
}
