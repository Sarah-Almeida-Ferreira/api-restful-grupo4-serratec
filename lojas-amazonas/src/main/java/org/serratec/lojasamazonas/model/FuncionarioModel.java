package org.serratec.lojasamazonas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Funcionario")
public class FuncionarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_cd_funcionario")
	private Long codigoFuncionario;

	@NotNull
	@Column(name = "funcionario_tx_nome_funcionario")
	private String nomeFuncionario;

	@NotNull
	@Column(unique = true)
	private String cpf;

	@OneToMany(mappedBy = "funcionario")
	@Column(name = "funcionario_list_produtos")
	private List<ProdutoModel> produtos;

	public FuncionarioModel() {
	}

	public FuncionarioModel(Long codigoFuncionario, String nomeFuncionario, String cpf) {
		super();
		this.codigoFuncionario = codigoFuncionario;
		this.nomeFuncionario = nomeFuncionario;
		this.cpf = cpf;
	}

	public Long getId() {
		return codigoFuncionario;
	}

	public void setId(Long id) {
		this.codigoFuncionario = id;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
