package br.edu.org.biblioteca.publica.service;

import br.edu.org.biblioteca.publica.domain.dto.CategoriaDTO;
import br.edu.org.biblioteca.publica.domain.model.Categoria;
import br.edu.org.biblioteca.publica.repository.CategoriaRepository;
import br.edu.org.biblioteca.publica.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository repository;

    public CategoriaDTO create(CategoriaDTO dto) {
        var categoria = MapperUtil.parseObject(dto, Categoria.class);
        var persiste = repository.save(categoria);
        return MapperUtil.parseObject(persiste, CategoriaDTO.class);
    }

    public CategoriaDTO update(CategoriaDTO dto) {
        var categoria = MapperUtil.parseObject(dto, Categoria.class);
        var persiste = repository.save(categoria);
        return MapperUtil.parseObject(persiste, CategoriaDTO.class);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public CategoriaDTO findCategoriaByID(Long id){
        return MapperUtil.parseObject(repository.findById(id).get(), CategoriaDTO.class);
    }

    public List<CategoriaDTO> getAll(){
        return MapperUtil.parseListObjects(repository.findAll(), CategoriaDTO.class);
    }
}
