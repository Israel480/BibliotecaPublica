package br.edu.org.biblioteca.publica.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class RevistaDTO {

    private Long id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;
    private int estoque;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao;
}
