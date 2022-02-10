package br.com.solinftec.treinamentospringboot.model;
import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Data
@Entity
@Table(name = "TIPO_SERVICO")
public class TipoServico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @OneToMany(mappedBy = "ordem_servico")
    @JsonBackReference
    private List<TipoServico> tiposServicos;

    public TipoServico(Long id) {
        this.id = id;
    }
}
