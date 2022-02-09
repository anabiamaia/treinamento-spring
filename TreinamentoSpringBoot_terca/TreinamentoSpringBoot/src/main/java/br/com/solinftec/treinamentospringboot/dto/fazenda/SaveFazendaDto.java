package br.com.solinftec.treinamentospringboot.dto.fazenda;

import br.com.solinftec.treinamentospringboot.model.Fazenda;
import lombok.Data;

@Data
public class SaveFazendaDto {
    private Long id;
    private String id_fazendeiro;
    private String descricao;
    private Boolean latitude;
    private Boolean longitude;
    
    public Fazenda pegarModel(){
        Fazenda fazenda = new Fazenda();
        fazenda.setId_fazendeiro(this.id_fazendeiro);
        fazenda.setDescricao(this.descricao);
        fazenda.setLatitude(this.latitude);
        fazenda.setLongitude(this.longitude);
    }
}
