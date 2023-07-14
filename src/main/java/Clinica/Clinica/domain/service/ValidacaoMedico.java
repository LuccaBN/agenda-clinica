package Clinica.Clinica.domain.service;

import Clinica.Clinica.domain.dto.DadosAgendarConsulta;
import Clinica.Clinica.domain.repository.MedicoRepository;
import Clinica.Clinica.domain.repository.ValidadorDeConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoMedico implements ValidadorDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendarConsulta dados){
        if (dados.idMedico() == null){
            return;
        }

//        var medicoAtivo = repository.findAtivoById(dados.idMedico());
//        if (!medicoAtivo) {
//            throw new ValidacaoException("Consulta não agendada pois médico não foi encontrado");
//        }
    }


}
