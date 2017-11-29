package br.facens.Vendas.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.facens.Vendas.DAO.ClienteDAO;
import br.facens.Vendas.devit.Cliente;

public class ClienteDAOTest {
	
	@Test
	//@Ignore	
	public void salvar() {
		Cliente c1 = new Cliente();
		c1.setNome("Nome");
		c1.setEndereco("Endereco");
		c1.setTelefone("32413513");
		c1.setStatus(1);
		c1.setLimite(5000.00);
		
		ClienteDAO dao = new ClienteDAO();
		dao.salvar(c1);
	}
	
	@Test
	@Ignore
	public void listar() {
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> clientes = dao.listar();
		
		for(Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		ClienteDAO dao = new ClienteDAO();
		Cliente c1 = dao.buscar(5L);
		
			System.out.println(c1);
	}
	
	@Test
	@Ignore
	public void excluir() {
		ClienteDAO dao = new ClienteDAO();
		Cliente c1 = dao.buscar(7L);
		
		dao.excluir(c1);
	}

	@Test
	@Ignore
	public void editar() {
		ClienteDAO dao = new ClienteDAO();
		Cliente c1 = dao.buscar(7L);
		c1.setNome("Laurenzita");
		
		dao.editar(c1);
	}

}
