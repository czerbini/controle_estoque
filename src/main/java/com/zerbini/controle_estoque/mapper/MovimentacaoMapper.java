package com.zerbini.controle_estoque.mapper;

import com.zerbini.controle_estoque.dto.MovimentacaoDTO;
import com.zerbini.controle_estoque.entity.Movimentacao;
import org.springframework.stereotype.Component;

@Component
public class MovimentacaoMapper {

    public MovimentacaoDTO toDTO(Movimentacao m) {

        MovimentacaoDTO dto = new MovimentacaoDTO();

        dto.setId(m.getId());
        dto.setProdutoId(m.getProdutoId());
        dto.setTipo(m.getTipo());
        dto.setQuantidade(m.getQuantidade());
        dto.setData(m.getData());

        return dto;
    }
}