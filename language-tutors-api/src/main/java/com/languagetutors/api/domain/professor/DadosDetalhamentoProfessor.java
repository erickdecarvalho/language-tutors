package com.languagetutors.api.domain.professor;

import com.languagetutors.api.domain.endereco.Endereco;

public record DadosDetalhamentoProfessor(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {
    public DadosDetalhamentoProfessor(Professor professor) {
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getCpf(), professor.getTelefone(), professor.getEndereco());

    }
}
