package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.remedio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "remedios")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String fabricante;
    private String principioAtivo;
    private String dosagem;
    private String formaFarmaceutica;
    private int quantidadeEmEstoque;
}
