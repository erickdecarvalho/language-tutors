package com.languagetutors.api.professor;

import com.languagetutors.api.endereco.DadosEndereco;

public record DadosCadastroProfessor(String nome, String email, String cpf, Idioma idioma, DadosEndereco endereco) {
}
