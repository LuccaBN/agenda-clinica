package Clinica.Clinica.domain.repository;

import Clinica.Clinica.domain.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
