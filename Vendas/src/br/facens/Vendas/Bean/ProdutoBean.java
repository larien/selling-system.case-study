package br.facens.Vendas.Bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.facens.Vendas.DAO.ProdutoDAO;
import br.facens.Vendas.devit.Produto;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	private Produto produto;
	private ArrayList<Produto>produtos;
	private ArrayList<Produto>produtosFiltrados;
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
			
			acao = JSFUtil.getParam("foracao");
			
			
			String valor = JSFUtil.getParam("codigoProduto");
			if(valor != null) {
				
				
				ProdutoDAO cdao = new ProdutoDAO();
				
				produto = cdao.buscar(codigo);
			} else {
					produto = new Produto();
				}
		}catch(RuntimeException e) {
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

		//produto = cdao.listar();
		
		produto = new Produto();
		JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso!");
		
	} catch (RuntimeException e) {
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
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void excluir() {
	try {
		ProdutoDAO cdao = new ProdutoDAO();
		cdao.excluir(produto);

		JSFUtil.adicionarMensagemSucesso("Fornecedor excluído com sucesso!");
	} catch (RuntimeException e) {
		JSFUtil.adicionarMensagemErro("Não foi possivel excluir o produto!");
		e.printStackTrace();
	}
}


}