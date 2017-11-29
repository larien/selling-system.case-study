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

import org.hibernate.validator.constraints.NotEmpty;

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
	
	@NotEmpty(message = "Quantidade obrigatória")
	@Column(name="quantidade", nullable=false)
	private Integer quantidade;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="numeroPedido", referencedColumnName="numero", nullable=false)
	private Pedido numeroPedido;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigoProduto", referencedColumnName="codigo", nullable=false)
	private Produto codigoProduto;

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

	public Pedido getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Pedido numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Produto getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Produto codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	@Override
	public String toString() {
		return "ItemPedido [numero=" + numero + ", valorParcial=" + valorParcial + ", quantidade=" + quantidade
				+ ", numeroPedido=" + numeroPedido + ", codigoProduto=" + codigoProduto + "]";
	}
}