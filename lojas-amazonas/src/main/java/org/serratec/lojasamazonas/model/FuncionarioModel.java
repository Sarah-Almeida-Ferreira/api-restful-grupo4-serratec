package org.serratec.lojasamazonas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Funcionario")
public class FuncionarioModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigoFuncionario;
	
	private String nomeFuncionario;
	
	@Column(unique=true)
	private String cpf;

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

