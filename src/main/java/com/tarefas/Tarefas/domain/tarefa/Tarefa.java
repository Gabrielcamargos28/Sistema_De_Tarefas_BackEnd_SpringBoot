package com.tarefas.Tarefas.domain.tarefa;

import com.tarefas.Tarefas.domain.cliente.Cliente;
import com.tarefas.Tarefas.domain.funcionario.Funcionario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name="Tarefa")
@Table(name="tarefa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tarefa")
    private Long id_tarefa;
    @Column(name="nome")
    private String nome;
    @Column(name="descricao")
    private String descricao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_id_funcionario")
    private Funcionario funcionario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_id_cliente")
    private Cliente cliente;
    @Column(name="data_limite")
    private LocalDateTime data_limite;

    public void cancelar(){

    }
}
