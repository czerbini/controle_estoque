package com.zerbini.controle_estoque.repository;

import com.zerbini.controle_estoque.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {}