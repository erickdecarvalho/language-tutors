package com.languagetutors.api.professor;

public record DadosListagemProfessores(Long id, String nome, String email, String cpf, Idioma idioma) {

    public DadosListagemProfessores(Professor professor) {
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getCpf(), professor.getIdioma());
    }

}
