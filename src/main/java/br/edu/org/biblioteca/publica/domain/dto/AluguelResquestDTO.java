package br.edu.org.biblioteca.publica.domain.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

@Data
public class AluguelResquestDTO {
    //é a requisição dos livros
    @NotNull
    private Long leitorId;

    private ArrayList<Long> livrosIds;

    // as datas serão geradas automaticamente pela parte do service
}
