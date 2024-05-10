package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.repository;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByLogin(String login);
}
