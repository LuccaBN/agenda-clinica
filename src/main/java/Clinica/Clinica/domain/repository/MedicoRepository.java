package Clinica.Clinica.domain.repository;

import Clinica.Clinica.domain.medico.Medico;
import Clinica.Clinica.domain.paciente.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> getReferenceByAtivoTrue(Pageable pageable);

//    @Query("""
//            select m.ativo
//            from Medico m
//            where m.id = :id
//            """)
//   Boolean findAtivoById(Long id);
}
