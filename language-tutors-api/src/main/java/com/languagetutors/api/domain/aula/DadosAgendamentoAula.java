package com.languagetutors.api.domain.aula;

import com.languagetutors.api.domain.professor.Idioma;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoAula(
        Long idProfessor,

        @NotNull
        Long idAluno,

        @NotNull
        @Future
        LocalDateTime data,

        Idioma idioma
) {
}
