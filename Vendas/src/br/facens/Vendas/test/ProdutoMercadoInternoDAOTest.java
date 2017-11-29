package br.facens.Vendas.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.facens.Vendas.DAO.ProdutoDAO;
import br.facens.Vendas.DAO.ProdutoMercadoInternoDAO;
import br.facens.Vendas.devit.Produto;
import br.facens.Vendas.devit.ProdutoMercadoInterno;

public class ProdutoMercadoInternoDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		ProdutoDAO produtodao = new ProdutoDAO();
		Produto produto = produtodao.buscar(2L);
		
		ProdutoMercadoInterno p1 = new ProdutoMercadoInterno();
		p1.setIncentivo(false);
		p1.setCodigoProduto(produto);
		
		ProdutoMercadoInternoDAO dao = new ProdutoMercadoInternoDAO();
		dao.salvar(p1);
	}
	
	@Test
	@Ignore
	public void listar() {
		ProdutoMercadoInternoDAO dao = new ProdutoMercadoInternoDAO();
		List<ProdutoMercadoInterno> psmi = dao.listar();
		
		for(ProdutoMercadoInterno pmi : psmi) {
			System.out.println(pmi);
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		ProdutoMercadoInternoDAO dao = new ProdutoMercadoInternoDAO();
		ProdutoMercadoInterno p1 = dao.buscar(2L);
		
			System.out.println(p1);
	}
	
	@Test
	@Ignore
	public void excluir() {
		ProdutoMercadoInternoDAO dao = new ProdutoMercadoInternoDAO();
		ProdutoMercadoInterno p1 = dao.buscar(2L);
		
		dao.excluir(p1);
	}

	@Test
	@Ignore
	public void editar() {
		ProdutoMercadoInternoDAO dao = new ProdutoMercadoInternoDAO();
		ProdutoMercadoInterno p1 = dao.buscar(2L);
		p1.setIncentivo(true);
		
		dao.editar(p1);
	}

}