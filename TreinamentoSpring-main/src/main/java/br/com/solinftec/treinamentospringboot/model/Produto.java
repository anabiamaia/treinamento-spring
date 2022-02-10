package br.com.solinftec.treinamentospringboot.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "PRODUTO")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "LATITUDE")
    private Float latitude;

    @Column(name = "ID_CIDADE")
    private Float id_cidade;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @OneToMany(mappedBy = "produto")
    @JsonBackReference
    private List<OrdemServico> ordensServicos;

    public Produto(Long id) {
        this.id = id;
    }
}
