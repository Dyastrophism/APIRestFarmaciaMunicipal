package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.repository;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Endereco findById(long id);

}
