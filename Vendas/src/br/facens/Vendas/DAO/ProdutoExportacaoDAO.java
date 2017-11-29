package br.facens.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.facens.Vendas.devit.ProdutoExportacao;
import br.facens.Vendas.util.HibernateUtil;

public class ProdutoExportacaoDAO {
	public void salvar(ProdutoExportacao produtoexportacao){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abre transação
			sessao.save(produtoexportacao);
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
	public List<ProdutoExportacao> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		List<ProdutoExportacao> produtosexportacao = null;
		
		try {
			Query consulta = sessao.getNamedQuery("ProdutoExportacao.listar");
			produtosexportacao = consulta.list();
		}catch(RuntimeException ex) {
			throw ex;
		}
			finally {
				sessao.close();
			}
		return produtosexportacao;
	}
	
	public ProdutoExportacao buscar(Long codigoProduto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		ProdutoExportacao produtoexportacao = null;
		
		try {
			Query consulta = sessao.getNamedQuery("ProdutoExportacao.buscar");
			consulta.setLong("codigoProduto", codigoProduto);
			produtoexportacao = (ProdutoExportacao)consulta.uniqueResult();
		}catch(RuntimeException ex) {
			throw ex;
		}
			finally {
				sessao.close();
			}
		return produtoexportacao;
	}
	
	public void excluir(ProdutoExportacao produtoexportacao){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abre transação
			sessao.delete(produtoexportacao);
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
		
	public void editar(ProdutoExportacao produtoexportacao){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abre transação
			sessao.update(produtoexportacao);
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