package com.languagetutors.api.professor;

import com.languagetutors.api.endereco.DadosEndereco;

public record DadosCadastroProfessor(String nome, String email, String crm, Idioma idioma, DadosEndereco endereco) {
}
