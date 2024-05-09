package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.enderecoDTO.DadosEnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record DadosAtaulizarMedicoDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoDTO endereco
) {
}
