package br.edu.org.biblioteca.publica.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    private Categoria categoria;

    private Autor autor;
    private float preco;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

    public Long getId(){
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor(){
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public float getPreco(){
        return preco;
    }

    public void setPreco(float preco){
        this.preco = preco;
    }

    public LocalDate getDataPublicacao(){
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate data){
        this.dataPublicacao = data;
    }

}
