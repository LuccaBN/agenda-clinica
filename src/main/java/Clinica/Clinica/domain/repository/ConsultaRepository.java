package Clinica.Clinica.domain.repository;

import Clinica.Clinica.domain.consulta.Consulta;
import Clinica.Clinica.domain.dto.DadosListaConsulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {


}
