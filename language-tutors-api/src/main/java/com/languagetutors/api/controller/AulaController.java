package com.languagetutors.api.controller;

import com.languagetutors.api.domain.aula.DadosAgendamentoAula;
import com.languagetutors.api.domain.aula.DadosDetalhamentoAula;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoAula dados) {
        return ResponseEntity.ok(new DadosDetalhamentoAula(null, null, null, null));
    }

}
