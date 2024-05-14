package com.languagetutors.api.controller;

import com.languagetutors.api.domain.aluno.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@SecurityRequirement(name = "bearer-key")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAluno dados, UriComponentsBuilder uriBuilder) {
        var aluno = new Aluno(dados);
        alunoRepository.save(aluno);

        var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAluno(aluno));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemAlunos>> listar() {
        var alunos = alunoRepository.findAll().stream().map(DadosListagemAlunos::new).toList();
        return ResponseEntity.ok(alunos);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados) {
        var aluno = alunoRepository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        alunoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
