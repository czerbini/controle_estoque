package com.zerbini.controle_estoque.repository;

import com.zerbini.controle_estoque.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    List<Movimentacao> findByProdutoId(Long id);
}