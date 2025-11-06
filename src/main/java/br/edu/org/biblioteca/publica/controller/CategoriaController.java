package br.edu.org.biblioteca.publica.controller;

import br.edu.org.biblioteca.publica.domain.dto.CategoriaDTO;
import br.edu.org.biblioteca.publica.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @PostMapping
    public CategoriaDTO create(@RequestBody CategoriaDTO dto){
        return service.create(dto);
    }

    @GetMapping("/all")
    public List<CategoriaDTO> getAll(){
        return service.getAll();
    }

    @PutMapping
    public  CategoriaDTO update(@RequestBody CategoriaDTO categoria){
        return service.update(categoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public CategoriaDTO findById(@PathVariable(name = "id") Long id){
        return service.findCategoriaByID(id);
    }
}
