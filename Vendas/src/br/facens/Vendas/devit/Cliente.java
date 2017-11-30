package br.facens.Vendas.devit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
@NamedQueries({
	@NamedQuery(name="Cliente.listar", query = "SELECT cliente FROM Cliente cliente"),
	@NamedQuery(name="Cliente.buscar", query = "SELECT cliente FROM Cliente cliente WHERE cliente.codigo = :codigo")
	})
public class Cliente {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="codigo")
	private Long codigo;
	
	@Column(name="nome", length=255, nullable=false)
	private String nome;
	
	// TODO - Adicionar CPF
//	@CPF(message = "CPF obrigatório")
//	@Column(name="nome", length=14, nullable=false)
//	private String cpf;
	
	@Column(name="endereco", length=500, nullable=true)
	private String endereco;
	
	@Column(name="telefone", length=20, nullable=true)
	private String telefone;
	
	@Column(name="status")
	private int status;
	
	@Column(name="limite")
	private double limite;	
	
	// TODO - implementar ItemPedido

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", status=" + status + ", limite=" + limite + "]";
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
