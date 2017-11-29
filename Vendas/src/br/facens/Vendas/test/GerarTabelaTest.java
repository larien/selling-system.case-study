package br.facens.Vendas.test;

import org.junit.Test;

import br.facens.Vendas.util.HibernateUtil;

public class GerarTabelaTest {

	@Test
	public void gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
		
	}

}
