package br.facens.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.facens.Vendas.devit.Cliente;
import br.facens.Vendas.util.HibernateUtil;

public class ClienteDAO {
	public void salvar(Cliente cliente){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abre transação
			sessao.save(cliente);
			transacao.commit();
		}catch(RuntimeException ex){
			if(transacao != null) {
				transacao.rollback();
		}
			throw ex;
		}
			finally {
				sessao.close();
			}
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		List<Cliente> clientes = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Cliente.listar");
			clientes = consulta.list();
		}catch(RuntimeException ex) {
			System.out.println("Listar:" + ex);
			throw ex;
		}
			finally {
				sessao.close();
			}
		return clientes;
	}
	
	public Cliente buscar(Long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Cliente cliente = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Cliente.buscar");
			consulta.setLong("codigo", codigo);
			cliente = (Cliente)consulta.uniqueResult();
		}catch(RuntimeException ex) {
			System.out.println("Buscar: " + ex);
			throw ex;
		}
			finally {
				sessao.close();
			}
		return cliente;
	}
	
	public void excluir(Cliente cliente){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abre transação
			sessao.delete(cliente);
			transacao.commit();
		}catch(RuntimeException ex){
			System.out.println("Excluir: " + ex);
			if(transacao != null) {
				transacao.rollback();
		}
			throw ex;
		}
			finally {
				sessao.close();
			}
	}
		
	public void editar(Cliente cliente){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abre transação
			sessao.update(cliente);
			transacao.commit();
		}catch(RuntimeException ex){
			System.out.println("Editar: " + ex);
			if(transacao != null) {
				transacao.rollback();
		}
			throw ex;
		}
			finally {
				sessao.close();
			}
	}	

}
