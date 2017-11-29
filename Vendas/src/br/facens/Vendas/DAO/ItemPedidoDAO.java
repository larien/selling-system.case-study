package br.facens.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.facens.Vendas.devit.ItemPedido;
import br.facens.Vendas.util.HibernateUtil;

public class ItemPedidoDAO {
	public void salvar(ItemPedido itempedido){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abre transação
			sessao.save(itempedido);
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
	public List<ItemPedido> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		List<ItemPedido> itenspedido = null;
		
		try {
			Query consulta = sessao.getNamedQuery("ItemPedido.listar");
			itenspedido = consulta.list();
		}catch(RuntimeException ex) {
			throw ex;
		}
			finally {
				sessao.close();
			}
		return itenspedido;
	}
	
	public ItemPedido buscar(Long numero){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		ItemPedido itempedido = null;
		
		try {
			Query consulta = sessao.getNamedQuery("ItemPedido.buscar");
			consulta.setLong("numero", numero);
			itempedido = (ItemPedido)consulta.uniqueResult();
		}catch(RuntimeException ex) {
			throw ex;
		}
			finally {
				sessao.close();
			}
		return itempedido;
	}
	
	public void excluir(ItemPedido itempedido){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abre transação
			sessao.delete(itempedido);
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
		
	public void editar(ItemPedido itempedido){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abre transação
			sessao.update(itempedido);
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