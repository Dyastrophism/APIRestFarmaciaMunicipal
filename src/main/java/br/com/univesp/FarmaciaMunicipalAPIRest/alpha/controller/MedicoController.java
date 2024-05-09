package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.controller;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.exceptions.ValidationException;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO.DadosAtaulizarMedicoDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO.DadosCadastroMedicoDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO.DadosDetalhamentoMedicoDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO.DadosListagemMedicoDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.repository.MedicoRepository;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.service.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicoDTO>> listarMedicos(@PageableDefault(size = 5, sort = {"nome"}) Pageable page) {
        var pagina = medicoService.listarMedicosAtivos(page);
        return ResponseEntity.ok(pagina);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarMedico(@RequestBody @Valid DadosAtaulizarMedicoDTO dadosAtualizarMedicoDTO) {
        try {
            medicoService.atualizarMedico(dadosAtualizarMedicoDTO);
            return ResponseEntity.ok().build();
        } catch (ValidationException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
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

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desativarMedico(@PathVariable Long id) {
        medicoService.desativarMedico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharMedico(@RequestParam Long id) {
        var medico = medicoService.detalharMedico(id);
        return ResponseEntity.ok(medico);
    }
}
