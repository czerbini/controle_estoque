package com.zerbini.controle_estoque.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovimentacaoDTO {
    private Long id;
    private Long produtoId;
    private String tipo;
    private Integer quantidade;
    private LocalDateTime data;
}
