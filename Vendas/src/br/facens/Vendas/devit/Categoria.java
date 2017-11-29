package br.facens.Vendas.devit;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Categoria")
@NamedQueries({
	@NamedQuery(name="Categoria.listar", query = "SELECT categoria FROM Categoria categoria"),
	@NamedQuery(name="Categoria.buscar", query = "SELECT categoria FROM Categoria categoria WHERE categoria.codigo = :codigo")
	})
public class Categoria {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="codigo")
	private Long codigo;
	
	@NotEmpty(message = "Descrição obrigatória")
	@Column(name="descricao", length=255, nullable=false)
	private String descricao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
	
}
	