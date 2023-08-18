package com.tarefas.Tarefas.domain.tarefa;

import java.time.LocalDateTime;

public record DadosAgendarTarefa(
        Long id_tarefa,
        String nome,
        String descricao,
        Long fk_id_cliente,
        Long fk_id_funcionario,
        LocalDateTime data_limite
){
}
