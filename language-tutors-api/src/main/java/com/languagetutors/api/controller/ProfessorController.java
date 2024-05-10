package com.languagetutors.api.controller;

import com.languagetutors.api.aluno.DadosDetalhamentoAluno;
import com.languagetutors.api.professor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProfessor dados, UriComponentsBuilder uriBuilder) {
        var professor = new Professor(dados);
        var uri = uriBuilder.path("/professores/{id}").buildAndExpand(professor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProfessor(professor));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemProfessores>> listar() {
        var professores = professorRepository.findAll().stream().map(DadosListagemProfessores::new).toList();

        return ResponseEntity.ok(professores);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoProfessor dados) {
        var professor = professorRepository.getReferenceById(dados.id());
        professor.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProfessor(professor));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        professorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
