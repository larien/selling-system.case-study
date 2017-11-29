package br.facens.Vendas.test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.facens.Vendas.DAO.PedidoDAO;
import br.facens.Vendas.DAO.ClienteDAO;
import br.facens.Vendas.devit.Pedido;
import br.facens.Vendas.devit.Cliente;

public class PedidoDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		ClienteDAO clientedao = new ClienteDAO();
		Cliente cliente = clientedao.buscar(8L);
		
		Pedido p1 = new Pedido();
		p1.setData(new Timestamp(System.currentTimeMillis()));
		p1.setCliente(cliente);
		p1.setValorTotal(new BigDecimal(159.99D));
		
		PedidoDAO dao = new PedidoDAO();
		dao.salvar(p1);
	}
	
	@Test
	@Ignore
	public void listar() {
		PedidoDAO dao = new PedidoDAO();
		List<Pedido> pedidos = dao.listar();
		
		for(Pedido pedido : pedidos) {
			System.out.println(pedido);
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		PedidoDAO dao = new PedidoDAO();
		Pedido p1 = dao.buscar(1L);
		
			System.out.println(p1);
	}
	
	@Test
	@Ignore
	public void excluir() {
		PedidoDAO dao = new PedidoDAO();
		Pedido p1 = dao.buscar(1L);
		
		dao.excluir(p1);
	}

	@Test
	@Ignore
	public void editar() {
		PedidoDAO dao = new PedidoDAO();
		Pedido p1 = dao.buscar(1L);
		p1.setValorTotal(new BigDecimal(99.99D));
		
		dao.editar(p1);
	}

}