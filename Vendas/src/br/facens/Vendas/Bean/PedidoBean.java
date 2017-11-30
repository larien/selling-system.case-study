package br.facens.Vendas.Bean;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.facens.Vendas.DAO.PedidoDAO;
import br.facens.Vendas.DAO.ProdutoDAO;
import br.facens.Vendas.devit.ItemPedido;
import br.facens.Vendas.devit.Pedido;
import br.facens.Vendas.devit.Produto;

@ManagedBean(name = "MBPedido")
@ViewScoped
public class PedidoBean {
	private Pedido pedido;
	private ArrayList<Pedido>pedidos;
	private ArrayList<Pedido>pedidosFiltrados;
	private String acao;
	
	private Produto produto;
	private ArrayList<Produto>produtos;
	private ArrayList<Produto>produtosFiltrados;
	
	private ArrayList<ItemPedido>itens;
	private ArrayList<ItemPedido>itensFiltrados;
		
	public ArrayList<ItemPedido> getItens() {
		if (itens == null) {
			itens = new ArrayList<ItemPedido>();
		}
		return itens;
	}

	public void setItens(ArrayList<ItemPedido> itens) {
		this.itens = itens;
	}

	public ArrayList<ItemPedido> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<ItemPedido> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
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

	public void setProdutosFiltrados(ArrayList<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

	public void setPedidosFiltrados(ArrayList<Pedido> pedidosFiltrados) {
		this.pedidosFiltrados = pedidosFiltrados;
	}

	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}

public Pedido getPedido() {
	
	return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public ArrayList<Pedido> getPedidosFiltrados() {
		return pedidosFiltrados;
	}

	public void setListarFiltrados(ArrayList<Pedido> pedidosFiltrados) {
		this.pedidosFiltrados = pedidosFiltrados;
	}

	public void prepararPesquisa() {
	try {
		PedidoDAO cdao = new PedidoDAO();
		pedidos = (ArrayList<Pedido>) cdao.listar();
	}catch(RuntimeException e) {
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}
	

	public void carregarProdutos() {
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
				
				PedidoDAO cdao = new PedidoDAO();
				
				pedido = cdao.buscar(codigo);
			} else {
					pedido = new Pedido();
				}
		}catch(RuntimeException e) {
			System.out.println("Carregar cadastro" + e);
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	public void novo() {
	pedido = new Pedido();
}
	
public void salvar() {
	try {
		PedidoDAO cdao = new PedidoDAO();
		cdao.salvar(pedido);

		//pedido = new Pedido();
		JSFUtil.adicionarMensagemSucesso("Pedido salvo com sucesso!");
		
	} catch (RuntimeException e) {
		System.out.println("Salvar" + e);
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void editar() {
	try {
		PedidoDAO cdao = new PedidoDAO();
		cdao.editar(pedido);
		
		JSFUtil.adicionarMensagemSucesso("Pedido editado com sucesso!");
		
	} catch (RuntimeException e) {
		System.out.println("Editar" + e);
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void excluir() {
	try {
		PedidoDAO cdao = new PedidoDAO();
		cdao.excluir(pedido);

		JSFUtil.adicionarMensagemSucesso("Pedido excluído com sucesso!");
	} catch (RuntimeException e) {
		System.out.println("Excluir" + e);
		JSFUtil.adicionarMensagemErro("Não foi possivel excluir o pedido!");
		e.printStackTrace();
	}
}

public void adicionar(Produto produto) {
	
	ItemPedido item = new ItemPedido();
	item.setProduto(produto);	
	
	
	int found = -1;
	
	for(int pos = 0; pos<itens.size() && found < 0;pos++) {
		ItemPedido temp = itens.get(pos);
		
		if(temp.getProduto().equals(produto)) {
			found = pos;
		}
	}
	
	if (found < 0) {
	item.setQuantidade(1);
	item.setValorParcial(produto.getPreco());
	itens.add(item);
	}else {
		ItemPedido temp = itens.get(found);
		item.setQuantidade(temp.getQuantidade() + 1);
		item.setValorParcial(produto.getPreco().multiply(new BigDecimal(item.getQuantidade())));
		itens.set(found,  item);
	}
}

public void remover(ItemPedido item) {
	int found = -1;
	
	for(int pos = 0; pos<itens.size() && found < 0;pos++) {
		ItemPedido temp = itens.get(pos);
		
		if(temp.getProduto().equals(item.getProduto())) {
			found = pos;
		}
		
		if (found > -1) {
			item.setQuantidade(temp.getQuantidade() - 1);
		}
		
		if (temp.getQuantidade() <= 0) {
			itens.remove(found);
		}
	}
}

}