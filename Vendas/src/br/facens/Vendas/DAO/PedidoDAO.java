package br.facens.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.facens.Vendas.devit.Pedido;
import br.facens.Vendas.util.HibernateUtil;

public class PedidoDAO {
	public void salvar(Pedido pedido){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abre transação
			sessao.save(pedido);
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
	public List<Pedido> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		List<Pedido> pedidos = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Pedido.listar");
			pedidos = consulta.list();
		}catch(RuntimeException ex) {
			throw ex;
		}
			finally {
				sessao.close();
			}
		return pedidos;
	}
	
	public Pedido buscar(Long numero){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Pedido pedido = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Pedido.buscar");
			consulta.setLong("numero", numero);
			pedido = (Pedido)consulta.uniqueResult();
		}catch(RuntimeException ex) {
			throw ex;
		}
			finally {
				sessao.close();
			}
		return pedido;
	}
	
	public void excluir(Pedido pedido){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abre transação
			sessao.delete(pedido);
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
		
	public void editar(Pedido pedido){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abre transação
			sessao.update(pedido);
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
}