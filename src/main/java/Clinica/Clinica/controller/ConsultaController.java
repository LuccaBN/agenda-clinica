package Clinica.Clinica.controller;

import Clinica.Clinica.domain.consulta.CentralConsultas;
import Clinica.Clinica.domain.dto.DadosAgendarConsulta;
import Clinica.Clinica.domain.dto.DadosDetalhesConsulta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private CentralConsultas central;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendarConsulta dados){
        central.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhesConsulta(null,null,null,null));
    }

}
