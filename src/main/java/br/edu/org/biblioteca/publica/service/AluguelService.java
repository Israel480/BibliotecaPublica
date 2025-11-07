package br.edu.org.biblioteca.publica.service;

import br.edu.org.biblioteca.publica.domain.model.Aluguel;
import br.edu.org.biblioteca.publica.domain.dto.AluguelResponseDTO;
import br.edu.org.biblioteca.publica.domain.dto.ALuguelResquestDTO;
import br.edu.org.biblioteca.publica.repository.AluguelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    // Método 1: CREATE (Criar) e UPDATE (Atualizar)
    @Transactional
    public AluguelResponseDTO salvar(Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    // Método 2: READ (Ler - todos)
    public List<AluguelResponseDTO> buscarTodos() {
        return aluguelRepository.findAll();
    }

    // Método 3: READ (Ler - por ID)
    public Optional<Aluguel> buscarPorId(Long id) {
        return aluguelRepository.findById(id);
    }

    // Método 4: DELETE (Deletar)
    @Transactional
    public void deletar(Long id) {
        // Implementar lógica de negócio aqui, como verificar se o livro foi devolvido
        aluguelRepository.deleteById(id);
    }

    // Método para UPDATE: Busca a entidade, atualiza os campos e salva.
    @Transactional
    public Aluguel atualizar(Long id, Aluguel aluguelDetalhes) {
        Optional<Aluguel> aluguelExistente = aluguelRepository.findById(id);

        if (aluguelExistente.isPresent()) {
            Aluguel aluguel = aluguelExistente.get();

            // Atualiza os campos necessários
            aluguel.setDataEmprestimo(aluguelDetalhes.getDataEmprestimo());
            aluguel.setDataEntrega(aluguelDetalhes.getDataEntrega());
            aluguel.setDataDevolucaoReal(aluguelDetalhes.getDataDevolucaoReal());
            aluguel.setPrecoAluguel(aluguelDetalhes.getPrecoAluguel());
            aluguel.setName_user(aluguelDetalhes.getName_user());
            aluguel.setLeitor(aluguelDetalhes.getLeitor());
            aluguel.setName_book(aluguelDetalhes.getName_book());
            aluguel.setLivros(aluguelDetalhes.getLivros());

            return aluguelRepository.save(aluguel);
        } else {
            // Lançar uma exceção NotFound ou retornar null
            throw new RuntimeException("Aluguel não encontrado com ID: " + id);
        }
    }
}