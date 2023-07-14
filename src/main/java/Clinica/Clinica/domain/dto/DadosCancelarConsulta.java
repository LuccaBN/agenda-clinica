package Clinica.Clinica.domain.dto;

import Clinica.Clinica.domain.consulta.CancelamentoConsulta;
import jakarta.validation.constraints.NotNull;

public record DadosCancelarConsulta(
        @NotNull
        Long IdConsulta,
        @NotNull
        CancelamentoConsulta cancelamento) {
}
