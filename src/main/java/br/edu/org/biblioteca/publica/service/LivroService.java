package br.edu.org.biblioteca.publica.service;

import br.edu.org.biblioteca.publica.domain.dto.LeitorDTO;
import br.edu.org.biblioteca.publica.domain.dto.LivroLowDTO;
import br.edu.org.biblioteca.publica.domain.model.Categoria;
import br.edu.org.biblioteca.publica.domain.model.Livro;
import br.edu.org.biblioteca.publica.repository.LivroRepository;
import br.edu.org.biblioteca.publica.util.MapperUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;


    public LivroLowDTO create(LivroLowDTO dto) {
        var livro = MapperUtil.parseObject(dto, Livro.class);
        var BookPersist = repository.save(livro);

        return MapperUtil.parseObject(BookPersist, LivroLowDTO.class);
    }

    public LivroLowDTO update(LivroLowDTO dto){
        var livro = MapperUtil.parseObject(dto, Livro.class);
        var PersisteLivro = repository.save(livro);
        return MapperUtil.parseObject(PersisteLivro, LivroLowDTO.class);
    }

    public List<LivroLowDTO> getAll() {
        return MapperUtil.parseListObjects(repository.findAll(), LivroLowDTO.class);
    }

    public LivroLowDTO findLivroById(Long id) {
        return MapperUtil.parseObject(repository.findById(id).get(), LivroLowDTO.class);
    }

    public void  deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<LivroLowDTO> findALlByCategoria(String nome){
       return MapperUtil.parseListObjects(repository.findByCategoriaNome(nome), LivroLowDTO.class);
    }

//    @Transactional(readOnly = true)
//    public List<BookDto> findBooksByCategoryName(String categoryName) {
//        List<Book> books = bookRepository.findByCategoryNameFetchCategory(categoryName);
//        return books.stream()
//                .map(b -> new BookDto(b.getId(), b.getTitle()))
//                .toList();
//    }


    public  LivroLowDTO findByTitulo(String titulo){
        return MapperUtil.parseObject(repository.findByTitulo(titulo), LivroLowDTO.class);
    }

}
