package Clinica.Clinica.domain.repository;

import Clinica.Clinica.domain.paciente.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> getReferenceByAtivoTrue(Pageable pageable);
}
