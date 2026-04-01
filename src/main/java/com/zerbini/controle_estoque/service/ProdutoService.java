package com.zerbini.controle_estoque.service;

import com.zerbini.controle_estoque.entity.Movimentacao;
import com.zerbini.controle_estoque.entity.Produto;
import com.zerbini.controle_estoque.repository.ProdutoRepository;
import com.zerbini.controle_estoque.repository.MovimentacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final MovimentacaoRepository movimentacaoRepository;
    private final EmailService emailService;

    @Value("${mail.alert.destinatario}")
    private String emailAlerta;

    public Produto criar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = produtoRepository.findById(id).orElseThrow();

        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setEstoqueMinimo(produtoAtualizado.getEstoqueMinimo());

        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow();
    }

    public List<Produto> listarProduto() {
        return produtoRepository.findAll();
    }

    public Produto entrada(Long id, Integer quantidade) {
        Produto p = buscarPorId(id);

        p.setQuantidade(p.getQuantidade() + quantidade);
        produtoRepository.save(p);

        salvarMovimentacao(id, "ENTRADA", quantidade);
        verificarEstoque(p);

        return p;
    }

    public Produto saida(Long id, Integer quantidade) {
        Produto p = buscarPorId(id);

        if (p.getQuantidade() < quantidade) {
            throw new RuntimeException("Estoque insuficiente");
        }

        p.setQuantidade(p.getQuantidade() - quantidade);
        produtoRepository.save(p);

        salvarMovimentacao(id, "SAIDA", quantidade);
        verificarEstoque(p);

        return p;
    }

    private void salvarMovimentacao(Long id, String tipo, Integer qtd) {
        Movimentacao m = new Movimentacao();
        m.setProdutoId(id);
        m.setTipo(tipo);
        m.setQuantidade(qtd);

        movimentacaoRepository.save(m);
    }

    private void verificarEstoque(Produto p) {
        if (p.getQuantidade() <= p.getEstoqueMinimo()) {
            log.warn("⚠️ ESTOQUE BAIXO: Produto {} está com {} unidades",
                    p.getNome(), p.getQuantidade());
            String mensagem = "Atenção!\n\n"
                    + "O produto " + p.getNome() + " está com estoque baixo.\n"
                    + "Quantidade atual: " + p.getQuantidade() + " unidades\n"
                    + "Estoque mínimo: " + p.getEstoqueMinimo() + " unidades\n\n"
                    + "Por favor, providencie a reposição.";

            emailService.enviarEmail(
                    emailAlerta,
                    "⚠ Estoque Baixo - " + p.getNome(),
                    mensagem
            );
        }
    }
}