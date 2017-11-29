package br.facens.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.facens.Vendas.devit.ProdutoMercadoInterno;
import br.facens.Vendas.util.HibernateUtil;

public class ProdutoMercadoInternoDAO {
	public void salvar(ProdutoMercadoInterno pmi){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abre transação
			sessao.save(pmi);
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
	public List<ProdutoMercadoInterno> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		List<ProdutoMercadoInterno> psmi = null;
		
		try {
			Query consulta = sessao.getNamedQuery("ProdutoMercadoInterno.listar");
			psmi = consulta.list();
		}catch(RuntimeException ex) {
			throw ex;
		}
			finally {
				sessao.close();
			}
		return psmi;
	}
	
	public ProdutoMercadoInterno buscar(Long codigoProduto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		ProdutoMercadoInterno pmi = null;
		
		try {
			Query consulta = sessao.getNamedQuery("ProdutoMercadoInterno.buscar");
			consulta.setLong("codigoProduto", codigoProduto);
			pmi = (ProdutoMercadoInterno)consulta.uniqueResult();
		}catch(RuntimeException ex) {
			throw ex;
		}
			finally {
				sessao.close();
			}
		return pmi;
	}
	
	public void excluir(ProdutoMercadoInterno pmi){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abre transação
			sessao.delete(pmi);
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
		
	public void editar(ProdutoMercadoInterno pmi){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abre transação
			sessao.update(pmi);
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