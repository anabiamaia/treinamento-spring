package br.com.solinftec.treinamentospringboot.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Data
@Entity
@Table(name = "ORDEM_SERVICO")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATA_EXECUCAO")
    private Date data_execucao;
    
    @Column(name = "RATE_APLICACAO")
    private Float rate_aplicacao;

    @Column(name = "TOTAL_APLICACAO")
    private Float total_aplicacao;

    @ManyToOne
    @JoinColumn(name = "ID_COOPERATIVA")
    private Cooperativa cooperativa;

    @OneToMany(mappedBy = "ordem_servico")
    @JsonBackReference
    private List<Monitoramento> monitoramentos;

    public OrdemServico(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    @JsonManagedReference
    private OrdemServico ordem_servico;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_SERVICO")
    @JsonManagedReference
    private TipoServico tipoServico;

    @ManyToOne
    @JoinColumn(name = "ID_FAZENDA")
    @JsonManagedReference
    private Fazenda fazenda;


    

}