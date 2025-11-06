package br.edu.org.biblioteca.publica.controller;

import br.edu.org.biblioteca.publica.domain.dto.ErrorDTO;
import br.edu.org.biblioteca.publica.domain.dto.LivroDTO;
import br.edu.org.biblioteca.publica.domain.dto.LivroLowDTO;
import br.edu.org.biblioteca.publica.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/livro")
public class LivroController {
    @Autowired
    private LivroService service;


    @Operation(summary = "Cadastra dados referentes ao Livro",
            tags = "Livro")
    @ApiResponse(responseCode = "200", description = "Livro cadastrado com sucesso!")
    @ApiResponse(responseCode = "400", description = "Possíveis causas:" +
            "\n- O livro informado já existe" +
            "\n- O nome do Livro excede o limite de 100 caracteres.")
    @PostMapping
    public LivroDTO create(@RequestBody LivroDTO livro){
        return  service.create(livro);
    }

    @GetMapping("/all")
    public List<LivroLowDTO> GetAll(){
        return service.getAll();
    }

    @PutMapping
    public  LivroDTO update(@RequestBody LivroDTO livro){
        return service.update(livro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
         service.deleteById(id);
    }


    @Operation(summary = "Retorna os dados de um Livro baseado no ID",
            tags = "User")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Retorno dos dados do Livro"),
            @ApiResponse(responseCode = "404",
                    description = "O livro com o id " +
                            "informado não foi encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class)
                    ))
    })

    @GetMapping("/{id}")
    public LivroDTO getById(@PathVariable Long id) {
        return  service.findLivroById(id);
    }


//    @GetMapping("/by-categoria")
//    public ResponseEntity<List<LivroLowDTO>> getByCategoria(@RequestParam String nome) {
//        List<LivroLowDTO> livros = service.findALlByCategoria(nome);
//        return ResponseEntity.ok(livros);
//    }
//
//    @GetMapping("/by-titulo")
//    public ResponseEntity<LivroLowDTO> getByTitulo(@RequestParam String titulo) {
//        LivroLowDTO livro = service.findByTitulo(titulo);
//        return ResponseEntity.ok(livro);
//    }

}
