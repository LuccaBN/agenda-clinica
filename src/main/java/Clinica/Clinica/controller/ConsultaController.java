package Clinica.Clinica.controller;

import Clinica.Clinica.domain.consulta.Consulta;
import Clinica.Clinica.domain.dto.DadosAgendarConsulta;
import Clinica.Clinica.domain.dto.DadosCancelarConsulta;
import Clinica.Clinica.domain.dto.DadosListaConsulta;
import Clinica.Clinica.domain.repository.ConsultaRepository;
import Clinica.Clinica.domain.service.CentralConsultas;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private CentralConsultas central;

    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendarConsulta dados){
        central.agendar(dados);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 10) Pageable pag){
        var list = central.listar(pag);
        return ResponseEntity.ok(list);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelarConsulta dados){
        central.cancelar(dados);
        return ResponseEntity.ok().build();
    }
}
