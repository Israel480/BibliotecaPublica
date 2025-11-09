package br.edu.org.biblioteca.publica.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_leitor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;
    private String endereco;
    private String telefone;


    @Column(unique = true)
    private String login;
    @ToString.Exclude
    private String password;

    @Column(unique = true, nullable = false, length = 120)
    private String email;

}
