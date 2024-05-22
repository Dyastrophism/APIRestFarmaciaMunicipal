package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.endereco;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.enderecoDTO.DadosEnderecoDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.medico.Medico;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.paciente.Paciente;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "enderecos")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    @OneToMany(mappedBy = "enderecoMedico")
    private List<Medico> enderecoMedico;
    @OneToMany(mappedBy = "enderecoPaciente")
    private List<Paciente> enderecoPaciente;

    public Endereco(DadosEnderecoDTO dadosEnderecoDTO) {
        this.logradouro = dadosEnderecoDTO.logradouro();
        this.bairro = dadosEnderecoDTO.bairro();
        this.cep = dadosEnderecoDTO.cep();
        this.numero = dadosEnderecoDTO.numero();
        this.complemento = dadosEnderecoDTO.complemento();
        this.cidade = dadosEnderecoDTO.cidade();
        this.uf = dadosEnderecoDTO.uf();
    }
}
