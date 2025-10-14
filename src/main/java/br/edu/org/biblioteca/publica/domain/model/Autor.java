package br.edu.org.biblioteca.publica.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_autor")
@AllArgsConstructor
@NoArgsConstructor
public class Autor extends Leitor{

    private List<Livro> livros;

    public List<Livro> getLivros(){
        return livros;
    }

    public void adicionarLivro(Livro livro){
        this.livros.add(livro);
    }

    public void adicionarListaLivros(List<Livro> livros){
        this.livros.addAll(livros);
    }
}
