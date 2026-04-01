package com.zerbini.controle_estoque.mapper;

import com.zerbini.controle_estoque.dto.ProdutoDTO;
import com.zerbini.controle_estoque.entity.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoDTO toDTO(Produto p) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(p.getId());
        dto.setNome(p.getNome());
        dto.setQuantidade(p.getQuantidade());
        dto.setPreco(p.getPreco());
        dto.setEstoqueMinimo(p.getEstoqueMinimo());
        return dto;
    }

    public Produto toEntity(ProdutoDTO dto) {
        Produto p = new Produto();
        p.setId(dto.getId());
        p.setNome(dto.getNome());
        p.setQuantidade(dto.getQuantidade());
        p.setPreco(dto.getPreco());
        p.setEstoqueMinimo(dto.getEstoqueMinimo());
        return p;
    }
}