package br.com.solinftec.treinamentospringboot.dto.fazenda;

import lombok.Data;

@Data
public class GetAllFazendaDto {

    private Long id;
    private String id_fazendeiro;
    private String descricao;
    private Boolean latitude;
    private Boolean longitude;

    public GetAllFazendaDto(Fazenda Fazenda) {
        this.id = Fazenda.getId();
        this.id_fazendeiro = Fazenda.getId_fazendeiro();
        this.descricao = Fazenda.getDescricao();
        this.latitude = Fazenda.getLatitude();
        this.longitude = Fazenda.getLongitude();
    }
}
