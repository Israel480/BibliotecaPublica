package br.edu.org.biblioteca.publica.service;

//import br.edu.org.biblioteca.publica.domain.dto.LeitorDTO;
//import br.edu.org.biblioteca.publica.domain.dto.LeitorLowDTO;
//import br.edu.org.biblioteca.publica.domain.model.Aluguel;
//import br.edu.org.biblioteca.publica.domain.dto.AluguelResponseDTO;
////import br.edu.org.biblioteca.publica.domain.dto.AluguelResquestDTO;
//import br.edu.org.biblioteca.publica.domain.model.Leitor;
//import br.edu.org.biblioteca.publica.exception.ApiException;
//import br.edu.org.biblioteca.publica.repository.AluguelRepository;
//import br.edu.org.biblioteca.publica.util.MapperUtil;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AluguelService {
//
//    @Autowired
//    private AluguelRepository repository;
//
//    // Método 1: CREATE (Criar) e UPDATE (Atualizar)
//    @Transactional
//    public AluguelResponseDTO salvar(AluguelResponseDTO dto) {
//        var leitor = MapperUtil.parseObject(dto, Aluguel.class);
//        var leitorAux = repository.save(leitor);
//        return MapperUtil.parseObject(leitorAux, AluguelResponseDTO.class);
//    }
//
//    // Método 2: READ (Ler - todos)
//    public List<AluguelResponseDTO> buscarTodos() {
//        return MapperUtil.parseListObjects(repository.findAll(), AluguelResponseDTO.class);
//    }
//
//    // Método 3: READ (Ler - por ID)
//    public AluguelResponseDTO buscarPorId(Long id) {
//        var aluguel = repository.findById(id).orElseThrow(
//                () -> new ApiException(HttpStatus.NOT_FOUND,
//                        "publica.service.aluguel.notfound",
//                        "Aluguel não encontrado")
//        );
//        return MapperUtil.parseObject(aluguel, AluguelResponseDTO.class);
//    }
//
////    public AluguelResponseDTO buscarAluguelPorLeitor(Leitor leitor) {
////        var aluguel = repository.findById(leitor).orElseThrow(
////                () -> new ApiException(HttpStatus.NOT_FOUND,
////                        "publica.service.aluguel.notfound",
////                        "Aluguel não encontrado")
////        );
////        return MapperUtil.parseObject(aluguel, AluguelResponseDTO.class);
////    }
//
//    // Método 4: DELETE (Deletar)
//    @Transactional
//    public void deletar(Long id) {
//        // Implementar lógica de negócio aqui, como verificar se o livro foi devolvido
//        aluguelRepository.deleteById(id);
//    }
//
//    // Método para UPDATE: Busca a entidade, atualiza os campos e salva.
//    @Transactional
//    public Aluguel atualizar(Long id, Aluguel aluguelDetalhes) {
//        Optional<Aluguel> aluguelExistente = aluguelRepository.findById(id);
//
//        if (aluguelExistente.isPresent()) {
//            Aluguel aluguel = aluguelExistente.get();
//
//            // Atualiza os campos necessários
//            aluguel.setDataEmprestimo(aluguelDetalhes.getDataEmprestimo());
//            aluguel.setDataEntrega(aluguelDetalhes.getDataEntrega());
//            aluguel.setDataDevolucaoReal(aluguelDetalhes.getDataDevolucaoReal());
//            aluguel.setPrecoAluguel(aluguelDetalhes.getPrecoAluguel());
//            aluguel.setName_user(aluguelDetalhes.getName_user());
//            aluguel.setLeitor(aluguelDetalhes.getLeitor());
//            aluguel.setName_book(aluguelDetalhes.getName_book());
//            aluguel.setLivros(aluguelDetalhes.getLivros());
//
//            return aluguelRepository.save(aluguel);
//        } else {
//            // Lançar uma exceção NotFound ou retornar null
//            throw new RuntimeException("Aluguel não encontrado com ID: " + id);
//        }
//    }
//}