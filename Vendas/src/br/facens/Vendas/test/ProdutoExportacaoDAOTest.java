package br.facens.Vendas.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.facens.Vendas.DAO.ProdutoDAO;
import br.facens.Vendas.DAO.ProdutoExportacaoDAO;
import br.facens.Vendas.devit.Produto;
import br.facens.Vendas.devit.ProdutoExportacao;

public class ProdutoExportacaoDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		ProdutoDAO produtodao = new ProdutoDAO();
		Produto produto = produtodao.buscar(2L);
		
		ProdutoExportacao p1 = new ProdutoExportacao();
		p1.setDestino("Brasil");
		p1.setCodigoProduto(produto);
		
		ProdutoExportacaoDAO dao = new ProdutoExportacaoDAO();
		dao.salvar(p1);
	}
	
	@Test
	@Ignore
	public void listar() {
		ProdutoExportacaoDAO dao = new ProdutoExportacaoDAO();
		List<ProdutoExportacao> produtosexportacao = dao.listar();
		
		for(ProdutoExportacao produtoexportacao : produtosexportacao) {
			System.out.println(produtoexportacao);
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		ProdutoExportacaoDAO dao = new ProdutoExportacaoDAO();
		ProdutoExportacao p1 = dao.buscar(2L);
		
			System.out.println(p1);
	}
	
	@Test
	//@Ignore
	public void excluir() {
		ProdutoExportacaoDAO dao = new ProdutoExportacaoDAO();
		ProdutoExportacao p1 = dao.buscar(2L);
		
		dao.excluir(p1);
	}

	@Test
	@Ignore
	public void editar() {
		ProdutoExportacaoDAO dao = new ProdutoExportacaoDAO();
		ProdutoExportacao p1 = dao.buscar(2L);
		p1.setDestino("Inglaterra");
		
		dao.editar(p1);
	}

}