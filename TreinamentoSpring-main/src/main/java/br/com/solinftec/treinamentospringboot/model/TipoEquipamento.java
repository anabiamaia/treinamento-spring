package br.com.solinftec.treinamentospringboot.model;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Data
@Entity
@Table(name = "TIPO_EQUIPAMENTO")
public class TipoEquipamento {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @OneToMany(mappedBy = "tipo_equipamento")
    @JsonBackReference
    private List<Equipamento> equipamentos;

    public TipoEquipamento(Long id) {
        this.id = id;
    }
}
