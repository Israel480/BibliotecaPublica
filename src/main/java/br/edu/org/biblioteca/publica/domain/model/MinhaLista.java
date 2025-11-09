package br.edu.org.biblioteca.publica.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.internal.bytebuddy.dynamic.loading.InjectionClassLoader;

import java.util.List;

@Entity
@Data
@Table(name="tb_minha_lista")
@AllArgsConstructor
@NoArgsConstructor
public class MinhaLista {


    public enum StatusLeitura {
        PARA_LER, LENDO, ABANDONADO, FINALIZADO, FAVORITO
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leitor_id", nullable = false)
    private Leitor leitor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    // Coluna que armazena o status (como String no BD)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusLeitura status;

}
