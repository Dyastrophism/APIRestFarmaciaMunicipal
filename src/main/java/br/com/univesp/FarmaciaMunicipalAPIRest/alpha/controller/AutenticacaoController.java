package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.controller;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.usuario.DadosAutenticacao;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.usuario.Usuario;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.security.DadosTokenJWT;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private TokenService tokenService;

        @PostMapping
        public ResponseEntity login(@RequestBody @Valid DadosAutenticacao dadosAutenticacao) {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dadosAutenticacao.login(), dadosAutenticacao.senha());
            var authentication = authenticationManager.authenticate(authenticationToken);
            var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        }
}
