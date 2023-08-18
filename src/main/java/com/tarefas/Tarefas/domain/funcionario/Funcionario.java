package com.tarefas.Tarefas.domain.funcionario;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="Funcionario")
@Table(name="funcionario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_funcionario")
    private Long id_funcionario;
    @Column(name="nome")
    private String nome;
    @Column(name="telefone")
    private String telefone;
    @Column(name="cep")
    private String cep;
    @Column(name="numero")
    private String numero;
    @Column(name="ativo")
    private Boolean ativo;

    public Funcionario(DadosCadastroFuncionario dados){
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.ativo = true;
    }

    public void atualizarFuncionario(DadosAtualizacaoFuncionario dados){
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.cep = dados.cep();
        this.numero = dados.numero();
    }
    public void desabilitar() {
        this.ativo = false;
    }
}
