package br.edu.org.biblioteca.publica.service;

import br.edu.org.biblioteca.publica.domain.dto.LivroDTO;
import br.edu.org.biblioteca.publica.domain.dto.LivroLowDTO;
import br.edu.org.biblioteca.publica.domain.model.Livro;
import br.edu.org.biblioteca.publica.repository.LivroRepository;
import br.edu.org.biblioteca.publica.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;


    public LivroDTO create(LivroDTO dto) {
        if (dto.getDataCriation() == null) {
            dto.setDataCriation(LocalDate.now());
        }
        var livro = MapperUtil.parseObject(dto, Livro.class);

        var BookPersist = repository.save(livro);

        return MapperUtil.parseObject(BookPersist, LivroDTO.class);
    }

    public LivroDTO update(LivroDTO dto){
        var livro = MapperUtil.parseObject(dto, Livro.class);
        var PersisteLivro = repository.save(livro);

        return MapperUtil.parseObject(PersisteLivro, LivroDTO.class);
    }

    public List<LivroLowDTO> getAll() {
        return MapperUtil.parseListObjects(repository.findAll(), LivroLowDTO.class);
    }

    public LivroDTO findLivroById(Long id) {
        return MapperUtil.parseObject(repository.findById(id).get(), LivroDTO.class);
    }

    public void  deleteById(Long id) {
        repository.deleteById(id);
    }
//
//    public List<LivroLowDTO> findALlByCategoria(String nome){
//       return MapperUtil.parseListObjects(repository.findByCategoriaNome(nome), LivroLowDTO.class);
//    }

    public  LivroLowDTO findByTitulo(String titulo){
        var livro = repository.findByTitulo(titulo);

        return MapperUtil.parseObject(livro, LivroLowDTO.class);
    }

}
