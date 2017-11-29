package br.facens.Vendas.main;

import br.facens.Vendas.util.HibernateUtil;

public class GerarTabela {

	public static void main(String[] args) {
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
		
	}
	
}
