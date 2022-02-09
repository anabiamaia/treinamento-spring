package br.com.solinftec.treinamentospringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.com.solinftec.treinamentospringboot.dto.fazenda.GetAllFazendaDto;
import br.com.solinftec.treinamentospringboot.dto.fazenda.SaveFazendaDto;
import br.com.solinftec.treinamentospringboot.model.Fazenda;
import br.com.solinftec.treinamentospringboot.repository.FazendaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FazendaService {
    private final FazendaRepository repository;

    public List<GetAllFazendaDto> getAll() {
        return repository.findAll()
                .stream()
                .map(Fazenda -> new GetAllFazendaDto(Fazenda))
                .collect(Collectors.toList());
    }


    public SaveFazendaDto save(SaveFazendaDto saveFazendaDto) {
        Fazenda Fazenda = saveFazendaDto.pegarModel();
        repository.save(Fazenda);
        saveFazendaDto.setId(Fazenda.getId());
        return saveFazendaDto;
    }

    public SaveFazendaDto update(SaveFazendaDto saveFazendaDto) throws Exception {

        Optional<Fazenda> Fazenda = repository.findById(saveFazendaDto.getId());

        if(Fazenda.isPresent()) {
            repository.save(saveFazendaDto.pegarModel());
            return saveFazendaDto;
        } else {
            throw new Exception("Fazenda_NOT_FOUND");
        }
    }

    public void deletar(Long idFazenda) throws Exception {

        Optional<Fazenda> Fazenda = repository.findById(idFazenda);

        if(Fazenda.isPresent()) {
            repository.delete(Fazenda.get());
        } else {
            throw new Exception("Fazenda_NOT_FOUND");
        }
    }
}
