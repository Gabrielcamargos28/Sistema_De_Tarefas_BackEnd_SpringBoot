package com.tarefas.Tarefas.domain.funcionario;

public record DadosDetalhamentoFuncionario(Long id_funcionario, String nome, String telefone, String cep, String numero, Boolean ativo){
    public DadosDetalhamentoFuncionario(Funcionario funcionario){
        this(funcionario.getId_funcionario(), funcionario.getNome(), funcionario.getTelefone(), funcionario.getCep(), funcionario.getNumero(),funcionario.getAtivo());
    }
}
