package com.zerbini.controle_estoque.repository;

import com.zerbini.controle_estoque.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
