package Clinica.Clinica.domain.service;

import Clinica.Clinica.domain.consulta.Consulta;
import Clinica.Clinica.domain.dto.DadosAgendarConsulta;
import Clinica.Clinica.domain.dto.DadosCancelarConsulta;
import Clinica.Clinica.domain.dto.DadosListaConsulta;
import Clinica.Clinica.domain.repository.ConsultaRepository;
import Clinica.Clinica.domain.repository.MedicoRepository;
import Clinica.Clinica.domain.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentralConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;


    public void agendar(DadosAgendarConsulta dados) {
        if (dados.idPaciente() != null && !pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Paciente não encontrado");
        }

        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Medico selecionado não está disponivel");
        }

        var medico = medicoRepository.findById(dados.idMedico()).get();
        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var consulta = new Consulta(null, medico, paciente, dados.dataHora(), null);
        consultaRepository.save(consulta);
    }

    public Page<DadosListaConsulta> listar(Pageable pag) {
        return consultaRepository.findAll(pag).map(DadosListaConsulta::new);
    }

    public void cancelar(DadosCancelarConsulta dados) {
        if (!consultaRepository.existsById(dados.IdConsulta())) {
            throw new ValidacaoException("Consulta não encontrada");
        }
        //validadoresCancelamento.forEach(v -> v.validar(dados));
        var consulta = consultaRepository.findById(dados.IdConsulta()).get();
        consulta.cancelar(dados.cancelamento());
    }
}
