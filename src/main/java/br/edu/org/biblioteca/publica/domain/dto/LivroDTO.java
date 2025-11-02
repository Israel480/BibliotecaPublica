package br.edu.org.biblioteca.publica.domain.dto;

import br.edu.org.biblioteca.publica.domain.model.Autor;
import br.edu.org.biblioteca.publica.domain.model.Categoria;
import lombok.Data;
import java.time.LocalDate;

@Data
public class LivroDTO {

    private Long id;
    private String titulo;
    private Categoria categoria;
    private Autor autor;
    private float preco;
    private LocalDate dataPublicacao;
}
