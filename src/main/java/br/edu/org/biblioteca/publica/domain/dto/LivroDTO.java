package br.edu.org.biblioteca.publica.domain.dto;

import br.edu.org.biblioteca.publica.domain.model.Autor;
import br.edu.org.biblioteca.publica.domain.model.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class LivroDTO {
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;
    private int estoque;
    private Autor autor;
    private Categoria categoria;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

}
