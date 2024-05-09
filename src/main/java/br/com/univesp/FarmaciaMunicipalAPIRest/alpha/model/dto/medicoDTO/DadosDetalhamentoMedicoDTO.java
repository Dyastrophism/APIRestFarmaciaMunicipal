package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.endereco.Endereco;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.medico.EspecialidadeMedicoEnum;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.medico.Medico;

public record DadosDetalhamentoMedicoDTO(
        Long id,
        String nome,
        String email,
        String crm,
        String telefone,
        EspecialidadeMedicoEnum especialidadeMedicoEnum,
        Endereco endereco){

    public DadosDetalhamentoMedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidadeMedico(), medico.getEnderecoMedico());
    }
}
