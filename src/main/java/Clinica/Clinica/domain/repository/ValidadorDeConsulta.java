package Clinica.Clinica.domain.repository;

import Clinica.Clinica.domain.dto.DadosAgendarConsulta;

public interface ValidadorDeConsulta {
    void validar(DadosAgendarConsulta dados);
}
