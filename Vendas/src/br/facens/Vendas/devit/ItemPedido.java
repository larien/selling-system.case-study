package br.facens.Vendas.devit;

import java.io.Serializable;
import java.math.BigDecimal;

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

@Entity
@Table(name = "ItemPedido")
@NamedQueries({
	@NamedQuery(name="ItemPedido.listar", query = "SELECT itempedido FROM ItemPedido itempedido"),
	@NamedQuery(name="ItemPedido.buscar", query = "SELECT itempedido FROM ItemPedido itempedido WHERE itempedido.numero = :numero")
	})
public class ItemPedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3528294868095865383L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="numero")
	private Integer numero;
	
	@Column(name="valorParcial", nullable=false, scale=2, precision=7)
	private BigDecimal valorParcial;
	
	@Column(name="quantidade", nullable=false)
	private Integer quantidade;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigoProduto", referencedColumnName="codigo", nullable=false)
	private Produto produto;
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public BigDecimal getValorParcial() {
		return valorParcial;
	}

	public void setValorParcial(BigDecimal valorParcial) {
		this.valorParcial = valorParcial;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "ItemPedido [numero=" + numero + ", valorParcial=" + valorParcial + ", quantidade=" + quantidade
				+ ", produto=" + produto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
}