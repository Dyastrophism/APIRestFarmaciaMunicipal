package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.repository;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
