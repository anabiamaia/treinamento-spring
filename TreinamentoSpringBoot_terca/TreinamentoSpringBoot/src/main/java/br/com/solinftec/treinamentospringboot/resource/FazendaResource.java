package br.com.solinftec.treinamentospringboot.resource;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fazenda")
@RequiredArgsConstructor
public class FazendaResource {
    private static final Logger logger = LoggerFactory.getLogger(Fazenda.class);

    private final FazendaService service;

    @GetMapping("")
    public ResponseEntity<List<GetAllFazendaDto>> getAll() {
        try {
            return ResponseEntity.ok().body(service.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<SaveFazendaDto> save(@RequestBody SaveFazendaDto saveFazendaDto) {
        try {
            return ResponseEntity.ok().body(service.save(saveFazendaDto));
        } catch (Exception e) {
            logger.error("Erro ao salvar saveFazendaDto: {}", saveFazendaDto);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<SaveFazendaDto> update(@RequestBody SaveFazendaDto saveFazendaDto) {
        try {
            return ResponseEntity.ok().body(service.update(saveFazendaDto));
        } catch (Exception e) {
            logger.error("Erro ao atualizar saveFazendaDto: {}, error: {}", saveFazendaDto, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idFazenda}")
    public ResponseEntity<?> delete(@PathVariable("idFazenda") Long idFazenda) {
        try {
            service.deletar(idFazenda);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Erro ao deletar Fazenda: {}, error: {}", idFazenda, e.getMessage());

            if(e.getMessage().equals("Fazenda_NOT_FOUND"))
                return ResponseEntity.notFound().build();

            return ResponseEntity.badRequest().build();
        }
    }
}
