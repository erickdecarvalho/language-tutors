package com.languagetutors.api.domain.aula.validacoes;

import com.languagetutors.api.domain.aula.DadosAgendamentoAula;
import com.languagetutors.api.infra.exception.ValidacaoException;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorHorarioAntecedencia {

    public void validar(DadosAgendamentoAula dados) {

        var dataAula = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataAula).toMinutes();

        if (diferencaEmMinutos > 30) {
            throw new ValidacaoException("Aula deve ser agendada com 30 minutos de antecedência!");
        }

    }

}
