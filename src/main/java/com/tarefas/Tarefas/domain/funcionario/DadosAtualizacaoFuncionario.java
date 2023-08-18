package com.tarefas.Tarefas.domain.funcionario;


public record DadosAtualizacaoFuncionario(

        Long id_funcionario,
        String nome,
        String telefone,
        String cep,
        String numero
) {
}
