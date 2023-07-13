package Clinica.Clinica.domain.dto;

import Clinica.Clinica.domain.paciente.Paciente;

public record DadosDetalhesPaciente(Long id, String name, String cpf) {

    public DadosDetalhesPaciente(Paciente paciente) {

        this(paciente.getId(), paciente.getName(), paciente.getCpf());
    }
}
