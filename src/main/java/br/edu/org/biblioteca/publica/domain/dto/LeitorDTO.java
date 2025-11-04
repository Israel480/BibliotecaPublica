package br.edu.org.biblioteca.publica.domain.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
public class LeitorDTO {
    private long id;
    private String name;
    private String endereco;
    private String telefone;
    private String login;
    private String password;
    private String email;
    private float preco;


}
