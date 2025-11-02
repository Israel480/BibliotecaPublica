package br.edu.org.biblioteca.publica.service;

import br.edu.org.biblioteca.publica.domain.dto.LivroDTO;
import br.edu.org.biblioteca.publica.domain.dto.LivroLowDTO;
import br.edu.org.biblioteca.publica.domain.model.Livro;
import br.edu.org.biblioteca.publica.exception.ApiException;
import br.edu.org.biblioteca.publica.repository.LivroRepository;
import br.edu.org.biblioteca.publica.util.MapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public LivroDTO create(LivroDTO dto){
        if(dto.getTitulo().isEmpty()){
            throw new ApiException(HttpStatus.BAD_REQUEST,
                    "biblioteca.service.livro.badrequest",
                    "Título obrigatório");
        }

        if(dto.getTitulo().length() > 100){
            throw new ApiException(HttpStatus.BAD_REQUEST,
                    "biblioteca.service.livro.badrequest",
                    "Título excede o limite de 100 caracteres");
        }

        var livro = MapperUtil.parseObject(dto, Livro.class);
        var livroPersist = repository.save(livro);

        return MapperUtil.parseObject(livroPersist, LivroDTO.class);
    }

    public List<LivroLowDTO> getAll(){

        return MapperUtil.parseListObjects
                (repository.findAll(), LivroLowDTO.class);
    }

    public LivroDTO update(LivroDTO dto){
        var user = MapperUtil.parseObject(dto, Livro.class);
        var userPersist = repository.save(user);
        return MapperUtil.parseObject(userPersist, LivroDTO.class);
    }

    public void deleteUserById(Long id){
        repository.deleteById(id);
    }

    public LivroLowDTO findLivroById(Long id){
        var user = repository.findById(id).orElseThrow(
                () -> new ApiException(HttpStatus.NOT_FOUND,
                        "biblioteca.service.livro.notfound",
                        "Livro não encontrado")
        );
        return MapperUtil.parseObject(user, LivroLowDTO.class);
    }

}
