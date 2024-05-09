package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.medico;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO.DadosAtaulizarMedicoDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.endereco.Endereco;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO.DadosCadastroMedicoDTO;
import jakarta.persistence.*;
import lombok.*;
@Table
@Entity(name = "medico")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private boolean ativo;

    public Medico(DadosCadastroMedicoDTO dadosCadastroMedicoDTO) {
        this.nome = dadosCadastroMedicoDTO.nome();
        this.email = dadosCadastroMedicoDTO.email();
        this.crm = dadosCadastroMedicoDTO.crm();
        this.telefone = dadosCadastroMedicoDTO.telefone();
        this.especialidadeMedico = dadosCadastroMedicoDTO.especialidadeMedicoEnum();
        this.enderecoMedico = new Endereco(dadosCadastroMedicoDTO.endereco());
    }

    public void desativar() {
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosAtaulizarMedicoDTO dadosAtualizarMedicoDTO) {
        if (dadosAtualizarMedicoDTO.nome() != null) {
            this.nome = dadosAtualizarMedicoDTO.nome();
        }
        if (dadosAtualizarMedicoDTO.telefone() != null) {
            this.telefone = dadosAtualizarMedicoDTO.telefone();
        }
        if (dadosAtualizarMedicoDTO.endereco() != null) {
            this.enderecoMedico.atualizarInformacoesEndereco(dadosAtualizarMedicoDTO.endereco());
        }
    }
}
