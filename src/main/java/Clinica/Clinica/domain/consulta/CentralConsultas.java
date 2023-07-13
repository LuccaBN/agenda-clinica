package Clinica.Clinica.domain.consulta;

import Clinica.Clinica.domain.service.ValidacaoException;
import Clinica.Clinica.domain.dto.DadosAgendarConsulta;
import Clinica.Clinica.domain.repository.ConsultaRepository;
import Clinica.Clinica.domain.repository.MedicoRepository;
import Clinica.Clinica.domain.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentralConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;


    public void agendar(DadosAgendarConsulta dados){
        if (dados.idPaciente()!= null && !pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Paciente não encontrado");
        }

        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Medico selecionado não está disponivel");
        }

        var medico = medicoRepository.findById(dados.idMedico()).get();
        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var consulta = new Consulta(null,medico,paciente,dados.dataHora());
        consultaRepository.save(consulta);
    }
}
