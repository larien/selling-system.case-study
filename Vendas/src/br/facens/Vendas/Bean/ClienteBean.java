package br.facens.Vendas.Bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.facens.Vendas.DAO.ClienteDAO;
import br.facens.Vendas.devit.Cliente;

@ManagedBean(name = "MBCliente")
@ViewScoped
public class ClienteBean {
	private Cliente cliente;
	private ArrayList<Cliente>clientes;
	private ArrayList<Cliente>clientesFiltrados;
	private String acao;
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}

public Cliente getCliente() {
	
	return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}

	public void setListarFiltrados(ArrayList<Cliente> clientesFiltrados) {
		this.clientesFiltrados = clientesFiltrados;
	}

	public void prepararPesquisa() {
	try {
		ClienteDAO cdao = new ClienteDAO();
		clientes = (ArrayList<Cliente>) cdao.listar();
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
				
				ClienteDAO cdao = new ClienteDAO();
				
				cliente = cdao.buscar(codigo);
			} else {
					cliente = new Cliente();
				}
		}catch(RuntimeException e) {
			System.out.println("Carregar cadastro" + e);
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	public void novo() {
	cliente = new Cliente();
}
	
public void salvar() {
	try {
		ClienteDAO cdao = new ClienteDAO();
		cdao.salvar(cliente);

		//cliente = new Cliente();
		JSFUtil.adicionarMensagemSucesso("Cliente salvo com sucesso!");
		
	} catch (RuntimeException e) {
		System.out.println("Salvar" + e);
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void editar() {
	try {
		ClienteDAO cdao = new ClienteDAO();
		cdao.editar(cliente);
		
		JSFUtil.adicionarMensagemSucesso("Cliente editado com sucesso!");
		
	} catch (RuntimeException e) {
		System.out.println("Editar" + e);
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void excluir() {
	try {
		ClienteDAO cdao = new ClienteDAO();
		cdao.excluir(cliente);

		JSFUtil.adicionarMensagemSucesso("Cliente excluído com sucesso!");
	} catch (RuntimeException e) {
		System.out.println("Excluir" + e);
		JSFUtil.adicionarMensagemErro("Não foi possivel excluir o cliente!");
		e.printStackTrace();
	}
}


}