package com.languagetutors.api.controller;

import com.languagetutors.api.aluno.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroAluno dados) {
        alunoRepository.save(new Aluno(dados));
    }

    @GetMapping
    public List<DadosListagemAlunos> listar() {
        return alunoRepository.findAll().stream().map(DadosListagemAlunos::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados) {
        var aluno = alunoRepository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        alunoRepository.deleteById(id);
    }
}
