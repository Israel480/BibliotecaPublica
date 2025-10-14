package br.edu.org.biblioteca.publica.domain.model;

import br.edu.org.biblioteca.publica.domain.dto.LeitorLowDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "tb_aluguel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aluguel;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy") //para requisições HTTP
    @DateTimeFormat(pattern = "dd/MM/yyyy") //organiza a serialização(e o inverso) do JSON
    private LocalDate dataEmprestimo;

    @Column(nullable = false, name = "entrega-prevista")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntrega;

    @Column(name = "entrega-atrasada")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDevolucaoReal;

    @Column(nullable = false)
    private float precoAluguel;

    @Column(nullable = false, length = 255)
    private String name_user;

    @ManyToOne(fetch = FetchType.LAZY) // varios alugueis para um leitor
    @JoinColumn(name = "leitor_id", nullable = false)
    private Leitor leitor;

    @Column(nullable = false)
    private String name_book;

//    @Column(nullable = false)
//    private Long id_user;

//    @Column(nullable = false)
//    private Long id_book;

    @ManyToMany(fetch = FetchType.LAZY) //é um relacionamento muito para muitos entre aluguel e livro
    @JoinTable( // isso vai criar uma junção das tabelas
            name = "aluguel_livro",
            joinColumns = @JoinColumn(name = "aluguel_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    private ArrayList<LeitorLowDTO> livros;
}
