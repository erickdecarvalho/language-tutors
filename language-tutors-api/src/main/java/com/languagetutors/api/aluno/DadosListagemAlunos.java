package com.languagetutors.api.aluno;

import com.languagetutors.api.professor.Professor;

public record DadosListagemAlunos(Long id, String nome, String email, String cpf) {

    public DadosListagemAlunos(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf());
    }

}
