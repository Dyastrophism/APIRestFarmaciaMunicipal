package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.medico.EspecialidadeMedicoEnum;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.medico.Medico;

public record DadosListagemMedicoDTO(Long id, String nome, String email, String crm, EspecialidadeMedicoEnum especialidadeMedico) {
    public DadosListagemMedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidadeMedico());
    }
}
