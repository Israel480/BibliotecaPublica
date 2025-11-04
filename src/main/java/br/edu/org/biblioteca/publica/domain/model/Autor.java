package br.edu.org.biblioteca.publica.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@Table(name = "tb_autor")
@AllArgsConstructor
@NoArgsConstructor
public class Autor extends Leitor{

    //nome
    //

    private List<Livro> livros;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL) // a lista está mapeada pela propriedade "autor"
    public void adicionarLivro(Livro livro){
        this.livros.add(livro);
    }

    public void adicionarListaLivros(List<Livro> livros){
        this.livros.addAll(livros);
    }
}
