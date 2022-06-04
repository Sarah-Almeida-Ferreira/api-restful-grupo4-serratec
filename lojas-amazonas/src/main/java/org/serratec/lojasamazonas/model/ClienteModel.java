package org.serratec.lojasamazonas.model;

import java.util.Date;
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
@Table(name = "Cliente")
public class ClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_cd_cliente")
	private Long codigoCliente;

	@NotNull
	@Column(name = "cliente_tx_nome_completo")
	private String nomeCompleto;

	@Column(name = "cliente_tx_nome_usuario", unique = true)
	private String nomeUsuario;

	@NotNull
	@Column(name = "cliente_tx_email", unique = true)
	private String email;

	@NotNull
	@Column(name = "cliente_tx_cpf", unique = true)
	private String cpf;

	@NotNull
	@Column(name = "cliente_dt_nascimento")
	private Date dataNascimento;

	@NotNull
	@Column(name = "cliente_tx_endereco")
	private String endereco;

	@NotNull
	@Column(name = "cliente_tx_telefone")
	private String telefone;

	@OneToMany(mappedBy = "cliente")
	@Column(name = "cliente_list_pedidos")
	private List<PedidoModel> pedidos;

	public ClienteModel() {}

	public ClienteModel(String nomeCompleto, String nomeUsuario, String email, String cpf,
			Date dataNascimento, String endereco, String telefone) {
		this.nomeCompleto = nomeCompleto;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Long getCodigoCliente() {
		return codigoCliente;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

}
