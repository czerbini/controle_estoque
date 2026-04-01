package com.zerbini.controle_estoque.dto;

import lombok.Data;

@Data
public class ProdutoDTO {
    private Long id;
    private String nome;
    private Integer quantidade;
    private Double preco;
    private Integer estoqueMinimo;
}