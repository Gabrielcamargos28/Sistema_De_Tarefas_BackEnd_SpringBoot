package com.tarefas.Tarefas.domain.tarefa;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoTarefa(
        @NotNull
        Long id_tarefa
) {
}
