package Clinica.Clinica.domain.dto;

import Clinica.Clinica.domain.consulta.Consulta;
import java.time.LocalDateTime;

public record DadosListaConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime dataHora) {
    public DadosListaConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getDataHora());
    }
}
