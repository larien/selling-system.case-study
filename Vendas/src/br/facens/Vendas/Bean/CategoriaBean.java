package br.facens.Vendas.Bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.facens.Vendas.DAO.CategoriaDAO;
import br.facens.Vendas.devit.Categoria;

@ManagedBean(name = "MBCategoria")
@ViewScoped
public class CategoriaBean {
	private Categoria categoria;
	private ArrayList<Categoria>categorias;
	private ArrayList<Categoria>categoriasFiltradas;
	private String acao;
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}

public Categoria getCategoria() {
	
	return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}

	public ArrayList<Categoria> getCategoriasFiltrados() {
		return categoriasFiltradas;
	}

	public void setListarFiltrados(ArrayList<Categoria> categoriasFiltradas) {
		this.categoriasFiltradas = categoriasFiltradas;
	}

	public void prepararPesquisa() {
	try {
		CategoriaDAO cdao = new CategoriaDAO();
		categorias = (ArrayList<Categoria>) cdao.listar();
	}catch(RuntimeException e) {
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}
	
	public void carregarCadastro(){
		try {
			
			acao = JSFUtil.getParam("acao");
			
			String valor = JSFUtil.getParam("codigo");
			if(valor != null) {
				Long codigo = Long.parseLong(valor);
				
				CategoriaDAO cdao = new CategoriaDAO();
				
				categoria = cdao.buscar(codigo);
			} else {
					categoria = new Categoria();
				}
		}catch(RuntimeException e) {
			System.out.println("Carregar cadastro" + e);
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	public void novo() {
	categoria = new Categoria();
}
	
public void salvar() {
	try {
		CategoriaDAO cdao = new CategoriaDAO();
		cdao.salvar(categoria);

		//categoria = new Categoria();
		JSFUtil.adicionarMensagemSucesso("Categoria salva com sucesso!");
		
	} catch (RuntimeException e) {
		System.out.println("Salvar" + e);
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void editar() {
	try {
		CategoriaDAO cdao = new CategoriaDAO();
		cdao.editar(categoria);
		
		JSFUtil.adicionarMensagemSucesso("Categoria editada com sucesso!");
		
	} catch (RuntimeException e) {
		System.out.println("Editar" + e);
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void excluir() {
	try {
		CategoriaDAO cdao = new CategoriaDAO();
		cdao.excluir(categoria);

		JSFUtil.adicionarMensagemSucesso("Categoria excluída com sucesso!");
	} catch (RuntimeException e) {
		System.out.println("Excluir" + e);
		JSFUtil.adicionarMensagemErro("Não foi possivel excluir a categoria!");
		e.printStackTrace();
	}
}


}