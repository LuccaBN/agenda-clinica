package Clinica.Clinica.domain.paciente;

import Clinica.Clinica.domain.dto.DadosAtualizarPaciente;
import Clinica.Clinica.domain.dto.DadosCadastroPaciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;

    private boolean ativo = true;

    public Paciente(DadosCadastroPaciente dados) {
        this.name = dados.name();
        this.cpf = dados.cpf();
    }

    public void atualizarInfo(DadosAtualizarPaciente dados) {
        if (dados.name() != null) {
            this.name = dados.name();
        }
        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
    }

    public void excluir(){
        this.ativo = false;
    }
}
