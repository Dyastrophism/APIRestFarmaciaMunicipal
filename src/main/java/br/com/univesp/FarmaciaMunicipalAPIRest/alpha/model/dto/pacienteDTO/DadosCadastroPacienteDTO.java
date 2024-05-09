package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.pacienteDTO;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.enderecoDTO.DadosEnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPacienteDTO(
        @NotBlank
        String nome,
        @Email
        @NotBlank
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        String telefone,
        @NotBlank
        @Valid
        DadosEnderecoDTO endereco) {
}
