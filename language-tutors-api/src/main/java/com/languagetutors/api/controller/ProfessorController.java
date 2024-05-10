package com.languagetutors.api.controller;

import com.languagetutors.api.professor.DadosCadastroProfessor;
import com.languagetutors.api.professor.DadosListagemProfessores;
import com.languagetutors.api.professor.Professor;
import com.languagetutors.api.professor.ProfessorRepository;
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


}
