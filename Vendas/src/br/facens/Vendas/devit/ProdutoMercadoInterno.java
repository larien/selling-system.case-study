package br.facens.Vendas.devit;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ProdutoMercadoInterno")
@NamedQueries({
	@NamedQuery(name="ProdutoMercadoInterno.listar", query = "SELECT produtomercadointerno FROM ProdutoMercadoInterno produtomercadointerno"),
	@NamedQuery(name="ProdutoMercadoInterno.buscar", query = "SELECT produtomercadointerno FROM ProdutoMercadoInterno produtomercadointerno WHERE produtomercadointerno.codigoProduto = :codigoProduto")
	})
public class ProdutoMercadoInterno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5380828646345900633L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigoProduto", referencedColumnName="codigo", nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Produto codigoProduto;
	
	@NotEmpty(message = "Incentivo obrigatório")
	@Column(name="incentivo", nullable=false)
	private boolean incentivo;

	public Produto getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Produto codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public boolean isIncentivo() {
		return incentivo;
	}

	public void setIncentivo(boolean incentivo) {
		this.incentivo = incentivo;
	}

	@Override
	public String toString() {
		return "ProdutoMercadoInterno [codigoProduto=" + codigoProduto + ", incentivo=" + incentivo + "]";
	}
}