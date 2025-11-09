//package br.edu.org.biblioteca.publica.controller;
//
//import br.edu.org.biblioteca.publica.domain.dto.ErrorDTO;
//import br.edu.org.biblioteca.publica.domain.dto.LeitorDTO;
//import br.edu.org.biblioteca.publica.domain.dto.LeitorLowDTO;
//import br.edu.org.biblioteca.publica.service.LeitorService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/leitor")
//public class LeitorController {
//
//    @Autowired
//    private LeitorService leitorService;
//
//    @Operation(summary = "Cadastra novo leitor",
//            tags = "Leitor")
//    @ApiResponse(responseCode = "200", description = "Leitor cadastrado com sucesso!")
//    @ApiResponse(responseCode = "400", description = "Possíveis causas:" +
//            "\n- O leitor informado já existe" +
//            "\n- O nome do leitor excede o limite de 100 caracteres.")
//    @PostMapping
//    public LeitorDTO create(@RequestBody LeitorDTO leitor){
//        return  leitorService.create(leitor);
//    }
//
//    @GetMapping("/all")
//    public List<LeitorLowDTO> getAll(){
//        return leitorService.getAll();
//    }
//
//    @PutMapping
//    public LeitorDTO update(@RequestBody LeitorDTO leitor){
//        return leitorService.update(leitor);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable(name = "id") Long id){
//        leitorService.deleteLeitorById(id);
//    }
//
//    @Operation(summary = "Busca dos dados de um leitor pelo ID",
//            tags = "Leitor")
//    @ApiResponses({
//            @ApiResponse(responseCode = "200",
//                    description = "Retorno dos dados do leitor"),
//            @ApiResponse(responseCode = "404",
//                    description = "O leitor não encontrado",
//                    content = @Content(
//                            mediaType = "application/json",
//                            schema = @Schema(implementation = ErrorDTO.class)
//                    ))
//    })
//    @GetMapping("/{id}")
//    public LeitorLowDTO findById(@PathVariable(name = "id") Long id){
//        return leitorService.findLeitorById(id);
//    }
//}
