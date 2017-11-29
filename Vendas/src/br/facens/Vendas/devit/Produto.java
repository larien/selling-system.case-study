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

import org.hibernate.validator.constraints.NotEmpty;

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
	
	@NotEmpty(message = "Nome obrigatório")
	@Column(name="nome", length=80, nullable=false)
	private String nome;
	
	@NotEmpty(message = "Preço obrigatório")
	@Column(name="preco", nullable=false, scale=2, precision=7)
	private BigDecimal preco;
	
	@NotEmpty(message = "Moeda obrigatória")
	@Column(name="moeda", nullable=false)
	private Integer moeda;
	
	@NotEmpty(message = "Imposto obrigatório")
	@Column(name="imposto", nullable=false)
	private double imposto;
	
	@NotEmpty(message = "Quantidade obrigatória")
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
}