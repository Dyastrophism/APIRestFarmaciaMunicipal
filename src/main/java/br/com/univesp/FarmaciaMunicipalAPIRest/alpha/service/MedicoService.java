package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.service;

import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.exceptions.ValidationException;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO.DadosCadastroMedicoDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.dto.medicoDTO.MedicoDTO;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.model.medico.Medico;
import br.com.univesp.FarmaciaMunicipalAPIRest.alpha.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<MedicoDTO> listarMedicos() {
        return medicoRepository.findAll().stream().map(MedicoDTO::new).toList();
    }

    public  void cadastrarMedico(DadosCadastroMedicoDTO dadosCadastroMedicoDTO) {
        boolean medicoJaCadastrado = medicoRepository.existsByCrm(dadosCadastroMedicoDTO.crm());
        if (medicoJaCadastrado) {
            throw new ValidationException("CRM de médico já cadastrado!");
        }
        medicoRepository.save(new Medico(dadosCadastroMedicoDTO));
    }

}
