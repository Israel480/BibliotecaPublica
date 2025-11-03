package br.edu.org.biblioteca.publica.service;

import br.edu.org.biblioteca.publica.domain.model.Categoria;
import br.edu.org.biblioteca.publica.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository repository;

    public Categoria create(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria update(Categoria categoria){
        return  repository.save(categoria);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Categoria findCategoriaByID(Long id){
        return repository.findById(id).get();
    }

    public List<Categoria> getAll(){
        return repository.findAll();
    }
}
