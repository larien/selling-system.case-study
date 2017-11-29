package br.facens.Vendas.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.facens.Vendas.DAO.CategoriaDAO;
import br.facens.Vendas.devit.Categoria;

public class CategoriaDAOTest {
	
	@Test
	//@Ignore	
	public void salvar() {
		Categoria c1 = new Categoria();
		c1.setDescricao("Descricao");
		
		CategoriaDAO dao = new CategoriaDAO();
		dao.salvar(c1);
	}
	
	@Test
	@Ignore
	public void listar() {
		CategoriaDAO dao = new CategoriaDAO();
		List<Categoria> categorias = dao.listar();
		
		for(Categoria categoria : categorias) {
			System.out.println(categoria);
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		CategoriaDAO dao = new CategoriaDAO();
		Categoria c1 = dao.buscar(1L);
		
			System.out.println(c1);
	}
	
	@Test
	@Ignore
	public void excluir() {
		CategoriaDAO dao = new CategoriaDAO();
		Categoria c1 = dao.buscar(1L);
		
		dao.excluir(c1);
	}

	@Test
	@Ignore
	public void editar() {
		CategoriaDAO dao = new CategoriaDAO();
		Categoria c1 = dao.buscar(1L);
		c1.setDescricao("Descricaozita");
		
		dao.editar(c1);
	}

}