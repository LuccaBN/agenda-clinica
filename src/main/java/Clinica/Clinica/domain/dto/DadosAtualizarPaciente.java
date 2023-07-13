package Clinica.Clinica.domain.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarPaciente(
        @NotNull
        Long id,
        String name,
        String cpf
) {
}
