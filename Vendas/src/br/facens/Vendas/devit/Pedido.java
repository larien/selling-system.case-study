package br.facens.Vendas.devit;

import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Pedido")
@NamedQueries({
	@NamedQuery(name="Pedido.listar", query = "SELECT pedido FROM Pedido pedido"),
	@NamedQuery(name="Pedido.buscar", query = "SELECT pedido FROM Pedido pedido WHERE pedido.numero = :numero")
	})
public class Pedido {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="numero")
	private Long numero;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="data", nullable=true)
	private Date data;
	
	@Column(name="valorTotal", nullable=false, scale=2, precision=7)
	private BigDecimal valorTotal;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigoCliente", referencedColumnName="codigo", nullable=false)
	private Cliente cliente;

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date date) {
		this.data = date;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", data=" + data + ", valorTotal=" + valorTotal + ", cliente=" + cliente
				+ "]";
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
		Pedido other = (Pedido) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
}