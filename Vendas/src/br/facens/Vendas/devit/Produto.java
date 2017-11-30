package br.facens.Vendas.devit;

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
@Table(name = "Produto")
@NamedQueries({
	@NamedQuery(name="Produto.listar", query = "SELECT produto FROM Produto produto"),
	@NamedQuery(name="Produto.buscar", query = "SELECT produto FROM Produto produto WHERE produto.codigo = :codigo")
	})
public class Produto {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="codigo")
	private Long codigo;
	
	@Column(name="nome", length=80, nullable=false)
	private String nome;
	
	@Column(name="preco", nullable=false, scale=2, precision=7)
	private BigDecimal preco;
	
	@Column(name="moeda", nullable=false)
	private Integer moeda;
	
	@Column(name="imposto", nullable=false)
	private double imposto;
	
	@Column(name="quantidade", nullable=false)
	private Integer quantidade;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigoCategoria", referencedColumnName="codigo", nullable=false)
	private Categoria categoria;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getMoeda() {
		return moeda;
	}

	public void setMoeda(Integer moeda) {
		this.moeda = moeda;
	}

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", preco=" + preco + ", moeda=" + moeda + ", imposto="
				+ imposto + ", quantidade=" + quantidade + ", categoria=" + categoria + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}