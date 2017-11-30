package br.facens.Vendas.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.facens.Vendas.DAO.CategoriaDAO;
import br.facens.Vendas.devit.Categoria;

@FacesConverter("categoriaConverter")
public class CategoriaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			CategoriaDAO dao = new CategoriaDAO();
			Categoria categoria = dao.buscar(codigo);
			return categoria;
		}catch(RuntimeException e) {
		return null;
		}
	}

	@Override
	public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
try {
			Categoria categoria = (Categoria) objeto;
			Long codigo = categoria.getCodigo();
			return codigo.toString();
		}catch(RuntimeException e) {
		return null;
		}
	}
}
