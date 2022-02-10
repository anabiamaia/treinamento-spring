package br.com.solinftec.treinamentospringboot.model;
import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Data
@Entity
@Table(name = "EQUIPAMENTO")
public class Equipamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LATITUDE")
    private Float latitude;

    @Column(name = "LONGITUDE")
    private Float longitude;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_EQUIPAMENTO")
    @JsonManagedReference
    private TipoEquipamento tipo_equipamento;

    @OneToMany(mappedBy = "fazendeiro")
    @JsonBackReference
    private List<Monitoramento> monitoramentos;

    public Equipamento(Long id) {
        this.id = id;
    }
}
