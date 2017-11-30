package br.facens.Vendas.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.facens.Vendas.DAO.CategoriaDAO;
import br.facens.Vendas.DAO.ProdutoDAO;
import br.facens.Vendas.devit.Categoria;
import br.facens.Vendas.devit.Produto;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	private Produto produto;
	private ArrayList<Produto>produtos;
	private ArrayList<Produto>produtosFiltrados;
	private String acao;
	private List<Categoria>categorias;
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public void setProdutosFiltrados(ArrayList<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}

public Produto getProduto() {
	
	return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void setListarFiltrados(ArrayList<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

	public void prepararPesquisa() {
	try {
		ProdutoDAO cdao = new ProdutoDAO();
		produtos = (ArrayList<Produto>) cdao.listar();
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
				
				ProdutoDAO cdao = new ProdutoDAO();
				
				produto = cdao.buscar(codigo);
			} else {
					produto = new Produto();
				}
			
			CategoriaDAO dao = new CategoriaDAO();
			categorias = dao.listar();
		}catch(RuntimeException e) {
			System.out.println("Carregar cadastro" + e);
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	public void novo() {
	produto = new Produto();
}
	
public void salvar() {
	try {
		ProdutoDAO cdao = new ProdutoDAO();
		cdao.salvar(produto);

		//produto = new Produto();
		JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso!");
		
	} catch (RuntimeException e) {
		System.out.println("Salvar" + e);
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void editar() {
	try {
		ProdutoDAO cdao = new ProdutoDAO();
		cdao.editar(produto);
		
		JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso!");
		
	} catch (RuntimeException e) {
		System.out.println("Editar" + e);
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void excluir() {
	try {
		ProdutoDAO cdao = new ProdutoDAO();
		cdao.excluir(produto);

		JSFUtil.adicionarMensagemSucesso("Produto excluído com sucesso!");
	} catch (RuntimeException e) {
		System.out.println("Excluir" + e);
		JSFUtil.adicionarMensagemErro("Não foi possivel excluir o produto!");
		e.printStackTrace();
	}
}


}