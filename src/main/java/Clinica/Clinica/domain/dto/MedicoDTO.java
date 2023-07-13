//package Clinica.Clinica.domain.dto;
//
//import Clinica.Clinica.domain.medico.Especialidade;
//import Clinica.Clinica.domain.medico.Medico;
//import jakarta.validation.constraints.NotNull;
//
//public record MedicoDTO(Long id, String name, String crm, Especialidade especialidade) {
//
//    public static Medico AtualizarMedico(@NotNull Long id, String name, String crm, Especialidade especialidade) {
//        return new Medico(id, name, crm, especialidade);
//    }
//
//}
