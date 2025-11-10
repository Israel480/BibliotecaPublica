package br.edu.org.biblioteca.publica.controller;

import br.edu.org.biblioteca.publica.domain.dto.*;
import br.edu.org.biblioteca.publica.service.RevistaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/revista")
public class RevistaController {
    @Autowired
    private RevistaService service;


    @Operation(summary = "Cadastra dados referentes a revista",
            tags = "Revista")
    @ApiResponse(responseCode = "200", description = "Revista cadastrado com sucesso!")
    @ApiResponse(responseCode = "400", description = "Possíveis causas:" +
            "\n- A revista informada já existe" +
            "\n- O nome da revista excede o limite de 100 caracteres.")
    @PostMapping
    public RevistaDTO create(@RequestBody RevistaDTO revista){
        return  service.create(revista);
    }

    @Operation(summary = "Busca todos as revistas",
            tags = "Revista")
    @ApiResponse(responseCode = "200", description = "Busca bem sucedida!")
    @GetMapping("/all")
    public List<RevistaLowDTO> GetAll(){
        return service.getAll();
    }

    @Operation(summary = "Altera os dados de uma revista já cadastrada",
            tags = "Revista")
    @ApiResponse(responseCode = "200", description = "Revista atualizada com sucesso!")
    @ApiResponse(responseCode = "400", description = "Possíveis causas:" +
            "\n- A revista informada não existe" +
            "\n- O nome da revista excede o limite de 100 caracteres.")
    @PutMapping
    public  RevistaDTO update(@RequestBody RevistaDTO revista){
        return service.update(revista);
    }

    @Operation(summary = "Deleta uma revista com base no id",
            tags = "Revista")
    @ApiResponse(responseCode = "200", description = "Revista deletada com sucesso!")
    @ApiResponse(responseCode = "400", description = "Possíveis causas:" +
            "\n- A revista com id informado não existe")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        service.deleteById(id);
    }


    @Operation(summary = "Retorna os dados de uma revista baseado no ID",
            tags = "Revista")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Retorna dos dados da Revista"),
            @ApiResponse(responseCode = "404",
                    description = "Revista não encontrada",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class)
                    ))
    })
    @GetMapping("/{id}")
    public RevistaDTO getById(@PathVariable Long id) {
        return  service.findRevistaById(id);
    }
}
