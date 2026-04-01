package com.zerbini.controle_estoque.controller;

import com.zerbini.controle_estoque.entity.Movimentacao;
import com.zerbini.controle_estoque.repository.MovimentacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
@RequiredArgsConstructor
public class MovimentacaoController {

    private final MovimentacaoRepository movimentacaoRepository;

    @GetMapping
    public List<Movimentacao> listar() {
        return movimentacaoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    public List<Movimentacao> movimentacaoporProdutoId(@PathVariable Long id) {
        return movimentacaoRepository.findByProdutoId(id);
    }
}
