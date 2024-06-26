package com.languagetutors.api.domain.aluno;

import com.languagetutors.api.domain.endereco.Endereco;

public record DadosDetalhamentoAluno(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {
    public DadosDetalhamentoAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf(), aluno.getTelefone(), aluno.getEndereco());

    }
}