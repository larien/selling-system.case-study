package br.facens.Vendas.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.facens.Vendas.DAO.ProdutoDAO;
import br.facens.Vendas.DAO.ItemPedidoDAO;
import br.facens.Vendas.devit.Produto;
import br.facens.Vendas.devit.ItemPedido;

public class ItemPedidoDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		ProdutoDAO produtodao = new ProdutoDAO();
		Produto produto = produtodao.buscar(2L);
		
		ItemPedido ip1 = new ItemPedido();
		ip1.setQuantidade(3);
		ip1.setValorParcial(new BigDecimal(19.99D));
		ip1.setProduto(produto);
		
		ItemPedidoDAO dao = new ItemPedidoDAO();
		dao.salvar(ip1);
	}
	
	@Test
	@Ignore
	public void listar() {
		ItemPedidoDAO dao = new ItemPedidoDAO();
		List<ItemPedido> itenspedido = dao.listar();
		
		for(ItemPedido itempedido : itenspedido) {
			System.out.println(itempedido);
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		ItemPedidoDAO dao = new ItemPedidoDAO();
		ItemPedido ip1 = dao.buscar(1L);
		
			System.out.println(ip1);
	}
	
	@Test
	//@Ignore
	public void excluir() {
		ItemPedidoDAO dao = new ItemPedidoDAO();
		ItemPedido ip1 = dao.buscar(1L);
		
		dao.excluir(ip1);
	}

	@Test
	@Ignore
	public void editar() {
		ItemPedidoDAO dao = new ItemPedidoDAO();
		ItemPedido ip1 = dao.buscar(1L);
		ip1.setQuantidade(5);
		
		dao.editar(ip1);
	}

}