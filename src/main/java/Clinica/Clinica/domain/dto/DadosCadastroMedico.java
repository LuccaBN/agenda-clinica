package Clinica.Clinica.domain.dto;

import Clinica.Clinica.domain.medico.Especialidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(
    @NotBlank
    String name,
    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    String crm,
    Especialidade especialidade
) {
}
