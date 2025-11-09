package br.edu.org.biblioteca.publica.service;

import br.edu.org.biblioteca.publica.domain.dto.LivroDTO;
import br.edu.org.biblioteca.publica.domain.dto.LivroLowDTO;
import br.edu.org.biblioteca.publica.domain.dto.RevistaDTO;
import br.edu.org.biblioteca.publica.domain.dto.RevistaLowDTO;
import br.edu.org.biblioteca.publica.domain.model.Livro;
import br.edu.org.biblioteca.publica.domain.model.Revista;
import br.edu.org.biblioteca.publica.repository.LivroRepository;
import br.edu.org.biblioteca.publica.repository.RevistaRepository;
import br.edu.org.biblioteca.publica.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RevistaService {
    @Autowired
    private RevistaRepository repository;


    public RevistaDTO create(RevistaDTO dto) {
        if (dto.getDataCriacao() == null) {
            dto.setDataCriacao(LocalDate.now());
        }
        var revista = MapperUtil.parseObject(dto, Revista.class);

        var RevistaAux = repository.save(revista);

        return MapperUtil.parseObject(RevistaAux, RevistaDTO.class);
    }

    public RevistaDTO update(RevistaDTO dto){
        var revista = MapperUtil.parseObject(dto, Revista.class);
        var revistaAux = repository.save(revista);

        return MapperUtil.parseObject(revistaAux, RevistaDTO.class);
    }

    public List<RevistaLowDTO> getAll() {
        return MapperUtil.parseListObjects(repository.findAll(), RevistaLowDTO.class);
    }

    public RevistaDTO findRevistaById(Long id) {
        return MapperUtil.parseObject(repository.findById(id).get(), RevistaDTO.class);
    }

    public void  deleteById(Long id) {
        repository.deleteById(id);
    }
}
