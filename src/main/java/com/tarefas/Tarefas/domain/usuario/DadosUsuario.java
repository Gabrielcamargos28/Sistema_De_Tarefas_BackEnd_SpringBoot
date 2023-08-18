package com.tarefas.Tarefas.domain.usuario;

import jakarta.persistence.Column;

public record DadosUsuario(
        String nome,
        String login,
        String senha,
        UsuarioRole role
) {
}
