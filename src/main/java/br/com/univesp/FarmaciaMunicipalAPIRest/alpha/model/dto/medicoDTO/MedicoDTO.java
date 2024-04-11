package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.medico.EspecialidadeMedicoEnum;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.medico.Medico;

public record MedicoDTO(Long id, String nome, String  crm, EspecialidadeMedicoEnum especialidadeMedico) {

    public MedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEspecialidadeMedico());
    }
}
