package Clinica.Clinica.domain.consulta;

import Clinica.Clinica.domain.medico.Medico;
import Clinica.Clinica.domain.paciente.Paciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "consultas")
@Entity(name = "consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    private LocalDateTime dataHora;

    @Column(name = "cancelamento")
    @Enumerated(EnumType.STRING)
    private CancelamentoConsulta cancelamentoConsulta;

    public void cancelar(CancelamentoConsulta motivo){
        this.cancelamentoConsulta = motivo;
    }

}
