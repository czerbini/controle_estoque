package com.zerbini.controle_estoque.controller;

import com.zerbini.controle_estoque.entity.Produto;
import com.zerbini.controle_estoque.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoservice;

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoservice.criar(produto);
    }

    @GetMapping
    public List<Produto> listar() {
        return produtoservice.listarProduto();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return produtoservice.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoservice.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoservice.deletar(id);
    }

    @PostMapping("/{id}/entrada")
    public Produto entrada(@PathVariable Long id, @RequestParam Integer qtd) {
        return produtoservice.entrada(id, qtd);
    }

    @PostMapping("/{id}/saida")
    public Produto saida(@PathVariable Long id, @RequestParam Integer qtd) {
        return produtoservice.saida(id, qtd);
    }
}