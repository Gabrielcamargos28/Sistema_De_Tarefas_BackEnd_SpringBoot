package com.tarefas.Tarefas.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.tarefas.Tarefas.domain.ValidacaoException;
import com.tarefas.Tarefas.domain.cliente.ClienteRepository;
import com.tarefas.Tarefas.domain.funcionario.FuncionarioRepository;
import com.tarefas.Tarefas.domain.tarefa.*;
import com.tarefas.Tarefas.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class AgendadorDeTarefas {

        @Autowired
        TarefaRepository tarefaRepository;
        @Autowired
        ClienteRepository clienteRepository;
        @Autowired
        FuncionarioRepository funcionarioRepository;

        public DadosDetalhamentoTarefa agendar(DadosAgendarTarefa dados){
            var cliente = clienteRepository.getReferenceById(dados.fk_id_cliente());
            var funcionario = funcionarioRepository.getReferenceById(dados.fk_id_funcionario());
            var tarefa = new Tarefa(null, dados.nome(), dados.descricao(),funcionario,cliente,dados.data_limite());
            tarefaRepository.save(tarefa);
            return new DadosDetalhamentoTarefa(tarefa);
        }

        public Page<DadosDetalhamentoTarefa> mostrarTarefas(Pageable paginacao){
            var page = tarefaRepository.findAll(paginacao).map(DadosDetalhamentoTarefa::new);
            return page;
        }

        public void desativar(DadosCancelamentoTarefa dados){
            if(!tarefaRepository.existsById(dados.id_tarefa())){
                throw new ValidacaoException("Id da tarefa inexistente");
            }
            var tarefa = tarefaRepository.getReferenceById(dados.id_tarefa());
            tarefa.cancelar();
        }

}
