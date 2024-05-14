package com.languagetutors.api.domain.aula.validacoes;

import com.languagetutors.api.domain.aula.AulaRepository;
import com.languagetutors.api.domain.aula.DadosAgendamentoAula;
import com.languagetutors.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidadorProfessorComOutraAulaNoMesmoHorario {

    @Autowired
    private AulaRepository aulaRepository;

    public void validar(DadosAgendamentoAula dados) {
        var professorPossuiOutraAulaNoMesmoHorario = aulaRepository.existsByProfessorIdAndData(dados.idProfessor(), dados.data());

        if (professorPossuiOutraAulaNoMesmoHorario) {
            throw new ValidacaoException("Professor já possui outra aula no mesmo horário");
        }
    }

}
