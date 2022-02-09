package br.com.solinftec.treinamentospringboot.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "FAZENDA")
public class Fazenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_FAZENDEIRO")
    private String id_fazendeiro;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "LATITUDE")
    private Boolean latitude;
    
    @Column(name = "LONGITUDE")
    private Boolean longitude;

    @ManyToOne
    @JsonManagedReference
    @JoinTable(name = "FAZENDA_FAZENDEIRO",
        joinColumns={@JoinColumn(name = "ID_FAZENDA", referencedColumnName = "ID")},
        inverseJoinColumns = {@JoinColumn(name = "ID_FAZENDEIRO", referencedColumnName = "ID")});
}
