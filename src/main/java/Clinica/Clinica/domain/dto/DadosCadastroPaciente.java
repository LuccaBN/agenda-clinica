package Clinica.Clinica.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPaciente(
        @NotBlank
        String name,
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
        String cpf ) {
}
