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
	private ArrayList<Categoria>categoriasFiltrados;
	private String acao;
	private Long codigo;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

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
		return categoriasFiltrados;
	}

	public void setListarFiltrados(ArrayList<Categoria> categoriasFiltrados) {
		this.categoriasFiltrados = categoriasFiltrados;
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
			
			acao = JSFUtil.getParam("foracao");
			
			
			String valor = JSFUtil.getParam("codigoCategoria");
			if(valor != null) {
				
				
				CategoriaDAO cdao = new CategoriaDAO();
				
				categoria = cdao.buscar(codigo);
			} else {
					categoria = new Categoria();
				}
		}catch(RuntimeException e) {
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

		//categoria = cdao.listar();
		
		categoria = new Categoria();
		JSFUtil.adicionarMensagemSucesso("Categoria salvo com sucesso!");
		
	} catch (RuntimeException e) {
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void editar() {
	try {
		CategoriaDAO cdao = new CategoriaDAO();
		cdao.editar(categoria);
		
		JSFUtil.adicionarMensagemSucesso("Categoria editado com sucesso!");
		
	} catch (RuntimeException e) {
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void excluir() {
	try {
		CategoriaDAO cdao = new CategoriaDAO();
		cdao.excluir(categoria);

		JSFUtil.adicionarMensagemSucesso("Fornecedor excluído com sucesso!");
	} catch (RuntimeException e) {
		JSFUtil.adicionarMensagemErro("Não foi possivel excluir o categoria!");
		e.printStackTrace();
	}
}


}