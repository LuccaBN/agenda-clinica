package Clinica.Clinica.domain.dto;

import Clinica.Clinica.domain.paciente.Paciente;

public record DadosListaPasciente(Long id, String name, String cpf) {

    public DadosListaPasciente(Paciente paciente) {
        this(paciente.getId(), paciente.getName(), paciente.getCpf());
    }

}