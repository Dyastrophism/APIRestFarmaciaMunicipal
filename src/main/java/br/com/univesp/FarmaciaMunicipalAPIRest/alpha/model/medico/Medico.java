package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.medico;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.Endereco.Endereco;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO.DadosCadastroMedicoDTO;
import jakarta.persistence.*;
import lombok.*;
@Table
@Entity(name = "medico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;
    @Enumerated
    private EspecialidadeMedicoEnum especialidadeMedico;
    @Embedded
    private Endereco enderecoMedico;

    public Medico(DadosCadastroMedicoDTO dadosCadastroMedicoDTO) {
        this.nome = dadosCadastroMedicoDTO.nome();
        this.email = dadosCadastroMedicoDTO.email();
        this.crm = dadosCadastroMedicoDTO.crm();
        this.telefone = dadosCadastroMedicoDTO.telefone();
        this.especialidadeMedico = dadosCadastroMedicoDTO.especialidadeMedicoEnum();
        this.enderecoMedico = new Endereco(dadosCadastroMedicoDTO.endereco());
    }
}
