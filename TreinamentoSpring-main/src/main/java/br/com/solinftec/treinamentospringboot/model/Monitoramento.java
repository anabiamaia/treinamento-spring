package br.com.solinftec.treinamentospringboot.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "MONITORAMENTO")
public class Monitoramento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;    
    
    @Column(name = "LATITUDE")
    private Float latitude;

    @Column(name = "LONGITUDE")
    private Float longitude;

    @Column(name = "DATA_HORA")
    private Date data_hora;

    @ManyToOne
    @JoinColumn(name = "ID_EQUIPAMENTO")
    @JsonManagedReference
    private Equipamento equipamento;

    @ManyToOne
    @JoinColumn(name = "ID_ORDEM_SERVICO")
    @JsonManagedReference
    private OrdemServico ordem_servico;

}
