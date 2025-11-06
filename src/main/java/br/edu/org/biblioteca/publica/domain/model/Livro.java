package br.edu.org.biblioteca.publica.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.FetchProfile;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_livro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column
    private int estoque;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id", nullable = false)
//    private Categoria categoria;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "autor_id", nullable = false)
//    private Autor autor;

    @Column(nullable = false)
    private float preco;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriation;


    @PrePersist
    public void prePersist() {
        if (this.dataCriation == null) {
            this.dataCriation = LocalDate.now();
        }
    }
}