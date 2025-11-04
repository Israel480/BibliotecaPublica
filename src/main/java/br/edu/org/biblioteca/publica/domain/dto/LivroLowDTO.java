package br.edu.org.biblioteca.publica.domain.dto;
import br.edu.org.biblioteca.publica.domain.model.Categoria;
import lombok.Data;

@Data
public class LivroLowDTO {
    private Long id;
    private String titulo;
}