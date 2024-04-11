package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.controller;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.exceptions.ValidationException;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO.DadosCadastroMedicoDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO.MedicoDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> listarMedicos() {
        List<MedicoDTO> medicos = medicoService.listarMedicos();
        return ResponseEntity.ok(medicos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrarMedico(@RequestBody @Valid DadosCadastroMedicoDTO dadosCadastroMedicoDTO) {
        try {
            medicoService.cadastrarMedico(dadosCadastroMedicoDTO);
            return ResponseEntity.ok().build();
        } catch (ValidationException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
