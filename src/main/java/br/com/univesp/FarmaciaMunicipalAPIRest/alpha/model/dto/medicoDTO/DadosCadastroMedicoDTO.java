package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.enderecoDTO.DadosEnderecoDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.medico.EspecialidadeMedicoEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedicoDTO(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        EspecialidadeMedicoEnum especialidadeMedicoEnum,
        @NotNull
        @Valid
        DadosEnderecoDTO endereco,
        @NotNull
        boolean ativo) {
}
