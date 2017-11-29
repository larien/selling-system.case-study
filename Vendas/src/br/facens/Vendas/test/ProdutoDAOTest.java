package br.facens.Vendas.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.facens.Vendas.DAO.CategoriaDAO;
import br.facens.Vendas.DAO.ProdutoDAO;
import br.facens.Vendas.devit.Categoria;
import br.facens.Vendas.devit.Produto;

public class ProdutoDAOTest {
	
	@Test
	//@Ignore	
	public void salvar() {
		CategoriaDAO categoriadao = new CategoriaDAO();
		Categoria categoria = categoriadao.buscar(2L);
		
		Produto p1 = new Produto();
		p1.setNome("Nome Produto");
		p1.setCategoria(categoria);
		p1.setPreco(new BigDecimal(49.99D));
		p1.setMoeda(1);
		p1.setImposto(0.3D);
		p1.setQuantidade(5);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p1);
	}
	
	@Test
	@Ignore
	public void listar() {
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produtos = dao.listar();
		
		for(Produto produto : produtos) {
			System.out.println(produto);
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		ProdutoDAO dao = new ProdutoDAO();
		Produto p1 = dao.buscar(1L);
		
			System.out.println(p1);
	}
	
	@Test
	@Ignore
	public void excluir() {
		ProdutoDAO dao = new ProdutoDAO();
		Produto p1 = dao.buscar(1L);
		
		dao.excluir(p1);
	}

	@Test
	@Ignore
	public void editar() {
		ProdutoDAO dao = new ProdutoDAO();
		Produto p1 = dao.buscar(1L);
		p1.setNome("Arroz");
		
		dao.editar(p1);
	}

}