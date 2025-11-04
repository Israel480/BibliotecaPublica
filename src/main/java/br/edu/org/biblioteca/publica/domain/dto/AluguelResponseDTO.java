package br.edu.org.biblioteca.publica.domain.dto;

import br.edu.org.biblioteca.publica.domain.model.Livro;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class AluguelResponseDTO {
    // essa é a resposta para a requisição
    private Long id;
    private LeitorLowDTO leitor;
    private ArrayList<Livro> livros;
    private LocalDate dataEmprestimo;
    private LocalDate dataEntregaPrevista;
    private LocalDate dataDevolucaoReal;

    private float precoAluguel;
    private float multaCalculada; // pra quando fazer os calculos de multa
}
