package Clinica.Clinica.domain.dto;

import Clinica.Clinica.domain.medico.Especialidade;
import Clinica.Clinica.domain.medico.Medico;

public record DadosDetalhesMedico(Long id, String name, String crm, Especialidade especialidade) {

    public DadosDetalhesMedico(Medico medico) {

        this(medico.getId(), medico.getName(), medico.getCrm(), medico.getEspecialidade());
    }
}

