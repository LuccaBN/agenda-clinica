package Clinica.Clinica.controller;

import Clinica.Clinica.domain.dto.DadosAtualizarPaciente;
import Clinica.Clinica.domain.dto.DadosCadastroPaciente;
import Clinica.Clinica.domain.dto.DadosDetalhesPaciente;
import Clinica.Clinica.domain.dto.DadosListaPasciente;
import Clinica.Clinica.domain.paciente.*;
import Clinica.Clinica.domain.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder){
        var paciente = new Paciente(dados);
        repository.save(paciente);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhesPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListaPasciente>> listar(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        var page = repository.getReferenceByAtivoTrue(pageable).map(DadosListaPasciente::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarPaciente dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInfo(dados);
        return ResponseEntity.ok(new DadosDetalhesPaciente(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhesPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
        return ResponseEntity.noContent().build();
    }


}
