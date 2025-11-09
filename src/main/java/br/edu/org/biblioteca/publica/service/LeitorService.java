package br.edu.org.biblioteca.publica.service;

import br.edu.org.biblioteca.publica.domain.dto.LeitorDTO;
import br.edu.org.biblioteca.publica.domain.dto.LeitorLowDTO;
import br.edu.org.biblioteca.publica.domain.model.Leitor;
import br.edu.org.biblioteca.publica.exception.ApiException;
import br.edu.org.biblioteca.publica.repository.LeitorRepository;
import br.edu.org.biblioteca.publica.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeitorService {

    @Autowired
    private LeitorRepository repository;

    public LeitorDTO create(LeitorDTO dto){
        if(dto.getName().isEmpty()){
            throw new ApiException(HttpStatus.BAD_REQUEST,
                    "publica.service.leitor.badrequest",
                    "O nome é obrigatório.");
        }
        if(dto.getName().length() > 100){
            throw new ApiException(HttpStatus.BAD_REQUEST,
                    "publica.service.leitor.badrequest",
                    "Nome ultrapassou o limite de 100 caracteres");
        }
        var leitor = MapperUtil.parseObject(dto, Leitor.class);
        var leitorAux = repository.save(leitor);

        return MapperUtil.parseObject(leitorAux, LeitorDTO.class);
    }

    public List<LeitorLowDTO> getAll(){
        return MapperUtil.parseListObjects
                (repository.findAll(), LeitorLowDTO.class);
    }

    public LeitorDTO update(LeitorDTO dto){
        var leitor = MapperUtil.parseObject(dto, Leitor.class);
        var leitorAux = repository.save(leitor);
        return MapperUtil.parseObject(leitorAux, LeitorDTO.class);
    }

    public void deleteLeitorById(Long id){
        repository.deleteById(id);
    }

    public LeitorLowDTO findLeitorById(Long id){
        var leitor = repository.findById(id).orElseThrow(
                () -> new ApiException(HttpStatus.NOT_FOUND,
                        "publica.service.leitor.notfound",
                        "Leitor não encontrado")
        );
        return MapperUtil.parseObject(leitor, LeitorLowDTO.class);
    }
}
