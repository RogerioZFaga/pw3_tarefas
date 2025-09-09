package br.com.etechas.tarefas.dto;

import java.time.LocalDate;

public record TarefaCreateDTO(
        String titulo,
        String descricao,
        String responsavel,
        LocalDate dataLimite

) {
}
