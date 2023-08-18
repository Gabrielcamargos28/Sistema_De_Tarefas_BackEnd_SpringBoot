package com.tarefas.Tarefas.domain.funcionario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFuncionario(
        @NotNull(message = "nome nao pode ser null")
                @NotBlank
        String nome,
        @NotNull(message = "telefone nao pode ser null")
        @NotBlank
        String telefone,
        @NotNull
        @NotBlank
        String cep,
        @NotNull
        @NotBlank
        String numero) {
}
