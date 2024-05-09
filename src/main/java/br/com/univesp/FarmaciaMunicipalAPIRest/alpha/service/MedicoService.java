package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.service;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.exceptions.ValidationException;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO.DadosAtaulizarMedicoDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO.DadosCadastroMedicoDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO.DadosDetalhamentoMedicoDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO.DadosListagemMedicoDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.medico.Medico;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MedicoService {

    private MedicoRepository medicoRepository;

    public Page<DadosListagemMedicoDTO> listarMedicosAtivos(Pageable page) {
        return this.medicoRepository.findAllByAtivoTrue(page).map(DadosListagemMedicoDTO::new);
    }

    public void cadastrarMedico(DadosCadastroMedicoDTO dadosCadastroMedicoDTO) {
        boolean medicoJaCadastrado = this.medicoRepository.existsByCrm(dadosCadastroMedicoDTO.crm());
        if (medicoJaCadastrado) {
            throw new ValidationException("CRM de médico já cadastrado!");
        }
        this.medicoRepository.save(new Medico(dadosCadastroMedicoDTO));
    }

    public void atualizarMedico(DadosAtaulizarMedicoDTO dadosAtualizarMedicoDTO) {
        var medico = this.medicoRepository.getReferenceById(dadosAtualizarMedicoDTO.id());
        medico.atualizarInformacoes(dadosAtualizarMedicoDTO);
    }

    public void desativarMedico(Long id) {
        var medico = this.medicoRepository.getReferenceById(id);
        medico.desativar();
    }

    public DadosDetalhamentoMedicoDTO detalharMedico(Long id) {
        var medico = this.medicoRepository.getReferenceById(id);
        return new DadosDetalhamentoMedicoDTO(medico);
    }
}
