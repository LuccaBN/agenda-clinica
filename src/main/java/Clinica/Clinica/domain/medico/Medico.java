package Clinica.Clinica.domain.medico;

import Clinica.Clinica.domain.dto.DadosAtualizarMedico;
import Clinica.Clinica.domain.dto.DadosCadastroMedico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String crm;
    private Especialidade especialidade;

    private boolean ativo = true;

    public Medico(DadosCadastroMedico dados) {
        this.name = dados.name();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
    }

    public Medico(Long id, String name, String crm, Especialidade especialidade) {
    }

    public void atualizarInfo(DadosAtualizarMedico dados) {
        if (dados.name() != null) {
            this.name = dados.name();
        }
        if (dados.crm() != null) {
            this.crm = dados.crm();
        }
        if (dados.especialidade() != null) {
            this.especialidade = dados.especialidade();
        }
    }

    public void excluir() { this.ativo = false; }
}
