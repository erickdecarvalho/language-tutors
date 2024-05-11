package com.languagetutors.api.domain.aluno;

import com.languagetutors.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAluno(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
