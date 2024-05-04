package com.languagetutors.api.controller;

import com.languagetutors.api.professor.DadosCadastroProfessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroProfessor dados) {
        System.out.println(dados);
    }

}
