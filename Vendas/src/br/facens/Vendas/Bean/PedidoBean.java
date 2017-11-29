package br.facens.Vendas.Bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.facens.Vendas.DAO.PedidoDAO;
import br.facens.Vendas.devit.Pedido;

@ManagedBean(name = "MBPedido")
@ViewScoped
public class PedidoBean {
	private Pedido pedido;
	private ArrayList<Pedido>pedidos;
	private ArrayList<Pedido>pedidosFiltrados;
	private String acao;
	private Long numero;
	
	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
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
	
	public void carregarCadastro(){
		try {
			
			acao = JSFUtil.getParam("foracao");
			
			
			String valor = JSFUtil.getParam("numeroPedido");
			if(valor != null) {
				
				
				PedidoDAO cdao = new PedidoDAO();
				
				pedido = cdao.buscar(numero);
			} else {
					pedido = new Pedido();
				}
		}catch(RuntimeException e) {
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

		//pedido = cdao.listar();
		
		pedido = new Pedido();
		JSFUtil.adicionarMensagemSucesso("Pedido salvo com sucesso!");
		
	} catch (RuntimeException e) {
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
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void excluir() {
	try {
		PedidoDAO cdao = new PedidoDAO();
		cdao.excluir(pedido);

		JSFUtil.adicionarMensagemSucesso("Fornecedor excluído com sucesso!");
	} catch (RuntimeException e) {
		JSFUtil.adicionarMensagemErro("Não foi possivel excluir o pedido!");
		e.printStackTrace();
	}
}


}