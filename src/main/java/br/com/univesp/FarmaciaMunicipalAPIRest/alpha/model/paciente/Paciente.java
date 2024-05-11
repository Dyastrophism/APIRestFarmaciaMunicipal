package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.paciente;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.pacienteDTO.DadosCadastroPacienteDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    private boolean ativo;

    public Paciente(DadosCadastroPacienteDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void desativar() {
        this.ativo = false;
    }

}
