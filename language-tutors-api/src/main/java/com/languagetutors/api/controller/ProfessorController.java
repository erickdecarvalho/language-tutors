package com.languagetutors.api.controller;

import com.languagetutors.api.professor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroProfessor dados) {
        professorRepository.save(new Professor(dados));
    }

    @GetMapping
    public List<DadosListagemProfessores> listar() {
        return professorRepository.findAll().stream().map(DadosListagemProfessores::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoProfessor dados) {
        var professor = professorRepository.getReferenceById(dados.id());
        professor.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        professorRepository.deleteById(id);
    }
}
