package Clinica.Clinica.controller;

import Clinica.Clinica.domain.dto.DadosAtualizarMedico;
import Clinica.Clinica.domain.dto.DadosCadastroMedico;
import Clinica.Clinica.domain.dto.DadosDetalhesMedico;
import Clinica.Clinica.domain.dto.DadosListaMedicos;
import Clinica.Clinica.domain.medico.*;
import Clinica.Clinica.domain.repository.MedicoRepository;
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
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);
        repository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhesMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListaMedicos>> listar(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        var page = repository.getReferenceByAtivoTrue(pageable).map(DadosListaMedicos::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInfo(dados);
        return ResponseEntity.ok(new DadosDetalhesMedico(medico));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhesMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }
}
