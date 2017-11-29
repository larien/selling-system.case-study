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
@Table(name = "ProdutoExportacao")
@NamedQueries({
	@NamedQuery(name="ProdutoExportacao.listar", query = "SELECT produtoexportacao FROM ProdutoExportacao produtoexportacao"),
	@NamedQuery(name="ProdutoExportacao.buscar", query = "SELECT produtoexportacao FROM ProdutoExportacao produtoexportacao WHERE produtoexportacao.codigoProduto = :codigoProduto")
	})
public class ProdutoExportacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6779174305012829314L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigoProduto", referencedColumnName="codigo", nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Produto codigoProduto;
	
	@NotEmpty(message = "Destino obrigatório")
	@Column(name="destino", length=255, nullable=false)
	private String destino;
	
	public Produto getCodigoProduto() {
		return codigoProduto;
	}



	public void setCodigoProduto(Produto codigoProduto) {
		this.codigoProduto = codigoProduto;
	}



	public String getDestino() {
		return destino;
	}



	public void setDestino(String destino) {
		this.destino = destino;
	}



	@Override
	public String toString() {
		return "ProdutoExportacao [codigoProduto=" + codigoProduto + ", destino=" + destino + "]";
	}
}