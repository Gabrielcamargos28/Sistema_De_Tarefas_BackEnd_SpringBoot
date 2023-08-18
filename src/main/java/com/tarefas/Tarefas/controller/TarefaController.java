package com.tarefas.Tarefas.controller;

import com.tarefas.Tarefas.domain.funcionario.DadosDetalhamentoFuncionario;
import com.tarefas.Tarefas.domain.tarefa.DadosCancelamentoTarefa;
import com.tarefas.Tarefas.service.AgendadorDeTarefas;
import com.tarefas.Tarefas.domain.tarefa.DadosAgendarTarefa;
import com.tarefas.Tarefas.domain.tarefa.DadosDetalhamentoTarefa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*")
public class TarefaController {
    @Autowired
    private AgendadorDeTarefas agendadorDeTarefas;


    @PostMapping("agendartarefa")
    @Transactional
    public ResponseEntity agendarTarefa(@RequestBody DadosAgendarTarefa dados, UriComponentsBuilder uriBuilder){
        var dto = agendadorDeTarefas.agendar(dados);
        var uri = uriBuilder.path("/tarefas/{id}").buildAndExpand(dto.id_tarefa()).toUri();
        return ResponseEntity.ok().build();
    }

    @GetMapping("mostrartarefas")
    public Page<DadosDetalhamentoTarefa> mostrarTarefas(Pageable paginacao){
        var page = agendadorDeTarefas.mostrarTarefas(paginacao);
        return page;
    }

    @DeleteMapping("disabilitartarefa")
    @Transactional
    public ResponseEntity desabilitar(@RequestBody @Valid DadosCancelamentoTarefa dados){
        agendadorDeTarefas.desativar(dados);
        return ResponseEntity.noContent().build();
    }
}
