package com.languagetutors.api.domain.aula;

import java.time.LocalDateTime;

public record DadosDetalhamentoAula(Long id, Long idProfessor, Long idAluno, LocalDateTime data) {
}
