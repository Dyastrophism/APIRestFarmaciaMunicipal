package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.repository;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.medico.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Optional<Medico> findByNome(String nome);
    boolean existsByCrm(String crm);
    Page<Medico> findAllByAtivoTrue(Pageable page);
}
