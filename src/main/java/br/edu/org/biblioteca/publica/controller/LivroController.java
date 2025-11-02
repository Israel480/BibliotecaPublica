package br.edu.org.biblioteca.publica.controller;

import br.edu.org.biblioteca.publica.domain.dto.LivroDTO;
import br.edu.org.biblioteca.publica.domain.dto.LivroLowDTO;
import br.edu.org.biblioteca.publica.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class LivroController {

    @Autowired
    private LivroService livroService;

//    @Operation(summary = "Cadastra novo livro", tags = "Livro")
//    @ApiResponse(responseCode = "200", description = "Novo Livro Cadastrado!")
//    @ApiResponse(responseCode = "400", description = "Possíveis causas:" +
//            "\n- O livro informado já existe" +
//            "\n- O título do livro excede o limite de 100 caracteres.")
    @PostMapping
    public LivroDTO create(@RequestBody LivroDTO user){
        return livroService.create(user);
    }

    @GetMapping("/all")
    public List<LivroLowDTO> getAll(){
        return livroService.getAll();
    }

    @PutMapping
    public LivroDTO update(@RequestBody LivroDTO user){
        return livroService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        livroService.deleteUserById(id);
    }

//    @Operation(summary = "Retorna os dados de um livro pelo ID",
//            tags = "Livro")
//    @ApiResponses({
//            @ApiResponse(responseCode = "200",
//                    description = "Retorno dos dados do livro"),
//            @ApiResponse(responseCode = "404",
//                    description = "O livro não encontrado",
//                    content = @Content(
//                            mediaType = "application/json",
//                            schema = @Schema(implementation = ErrorDTO.class)
//                    ))
//    })
    @GetMapping("/{id}")
    public LivroLowDTO findById(@PathVariable(name = "id") Long id){
        return livroService.findLivroById(id);
    }

}
