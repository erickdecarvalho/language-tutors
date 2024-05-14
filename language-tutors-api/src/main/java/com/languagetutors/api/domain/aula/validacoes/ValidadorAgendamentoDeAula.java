package com.languagetutors.api.domain.aula.validacoes;

import com.languagetutors.api.domain.aula.DadosAgendamentoAula;

public interface ValidadorAgendamentoDeAula {
    void validar(DadosAgendamentoAula dados);
}
