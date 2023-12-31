package Clinica.Clinica.domain.dto;

import Clinica.Clinica.domain.consulta.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhesConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime dataHora) {

    public DadosDetalhesConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getDataHora());
    }
}
