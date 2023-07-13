package Clinica.Clinica.domain.dto;

import Clinica.Clinica.domain.medico.Especialidade;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico(
        @NotNull
        Long id,
        String name,
        String crm,
        Especialidade especialidade

) {
}
