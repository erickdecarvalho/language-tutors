package com.languagetutors.api.controller;

import com.languagetutors.api.domain.aula.AgendaDeAulas;
import com.languagetutors.api.domain.aula.DadosAgendamentoAula;
import com.languagetutors.api.domain.aula.DadosDetalhamentoAula;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    @Autowired
    private AgendaDeAulas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoAula dados) {
        var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }

}
