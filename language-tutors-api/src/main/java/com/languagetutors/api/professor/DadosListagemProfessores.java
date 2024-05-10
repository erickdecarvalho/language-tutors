package com.languagetutors.api.professor;

public record DadosListagemProfessores(String nome, String email, String cpf, Idioma idioma) {

    public DadosListagemProfessores(Professor professor) {
        this(professor.getNome(), professor.getEmail(), professor.getCpf(), professor.getIdioma());
    }

}
