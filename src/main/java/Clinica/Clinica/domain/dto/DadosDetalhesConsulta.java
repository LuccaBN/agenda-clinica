package Clinica.Clinica.domain.dto;

import java.time.LocalDateTime;

public record DadosDetalhesConsulta(
        Long id,
        Long idMedico,
        Long idPaciente,
        LocalDateTime dataHora) {
}
