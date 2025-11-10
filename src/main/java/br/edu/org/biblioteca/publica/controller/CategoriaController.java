package br.edu.org.biblioteca.publica.controller;

import br.edu.org.biblioteca.publica.domain.dto.CategoriaDTO;
import br.edu.org.biblioteca.publica.domain.dto.ErrorDTO;
import br.edu.org.biblioteca.publica.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @Operation(summary = "Cadastra nova categoria",
            tags = "Categoria")
    @ApiResponse(responseCode = "200", description = "Categoria cadastrada com sucesso!")
    @ApiResponse(responseCode = "400", description = "Possíveis causas:" +
            "\n- A categoria informada já existe")
    @PostMapping
    public CategoriaDTO create(@RequestBody CategoriaDTO dto){
        return service.create(dto);
    }

    @Operation(summary = "Busca todos as categorias",
            tags = "Categoria")
    @ApiResponse(responseCode = "200", description = "Busca bem sucedida!")
    @GetMapping("/all")
    public List<CategoriaDTO> getAll(){
        return service.getAll();
    }

    @Operation(summary = "Altera os dados de uma categoria já cadastrada",
            tags = "Categoria")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso!")
    @ApiResponse(responseCode = "400", description = "Possíveis causas:" +
            "\n- A categoria informada não existe")
    @PutMapping
    public  CategoriaDTO update(@RequestBody CategoriaDTO categoria){
        return service.update(categoria);
    }

    @Operation(summary = "Deleta uma categoria com base no id",
            tags = "Categoria")
    @ApiResponse(responseCode = "200", description = "Categoria deletada com sucesso!")
    @ApiResponse(responseCode = "400", description = "Possíveis causas:" +
            "\n- A categoria com id informado não existe")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        service.deleteById(id);
    }

    @Operation(summary = "Retorna os dados de uma categoria baseado no ID",
            tags = "Categoria")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Categoria encontrada com sucesso"),
            @ApiResponse(responseCode = "404",
                    description = "A categoria com o id " +
                            "informado não foi encontrada",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class)
                    ))
    })
    @GetMapping("/{id}")
    public CategoriaDTO findById(@PathVariable(name = "id") Long id){
        return service.findCategoriaByID(id);
    }
}
