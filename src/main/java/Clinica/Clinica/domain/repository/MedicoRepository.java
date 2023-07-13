package Clinica.Clinica.domain.repository;

import Clinica.Clinica.domain.medico.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> getReferenceByAtivoTrue(Pageable pageable);
}
