package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Avisa o Spring que essa classe é um controller e é gerada quando o projeto roda
@RequestMapping("funcionarios") // URL de acesso pra esse controller, por ele que recebe as funcoes do CRUD
public class FuncionarioController { // por padrao controller sao nomeados dessa forma

    @PostMapping // Aviso o spring que é uma req POST
    public void medicoCadastrar(@RequestBody String json) {
        System.out.println(json);
    }
}
