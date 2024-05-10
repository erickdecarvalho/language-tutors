package com.languagetutors.api.aluno;

import com.languagetutors.api.endereco.DadosEndereco;
import com.languagetutors.api.endereco.Endereco;
import com.languagetutors.api.professor.Idioma;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAluno(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        String cpf,
        @NotNull
        @Valid
        DadosEndereco endereco
) {
}
