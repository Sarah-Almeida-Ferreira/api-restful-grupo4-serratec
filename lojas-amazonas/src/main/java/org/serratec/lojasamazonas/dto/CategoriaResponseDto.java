package org.serratec.lojasamazonas.dto;

import java.util.List;

public class CategoriaResponseDto {
	
	private Long codigoCategoria;
	private String nomeCategoria;
	private List<Long> CodigosProdutos;
	
	
	public CategoriaResponseDto() {

	}
	
	public CategoriaResponseDto(Long codigoCategoria, String nomeCategoria, 
			List<Long> codigosProdutos) {
		this.codigoCategoria = codigoCategoria;
		this.nomeCategoria = nomeCategoria;
		CodigosProdutos = codigosProdutos;
	}
	public Long getCodigoCategoria() {
		return codigoCategoria;
	}
	public void setCodigoCategoria(Long codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public List<Long> getCodigosProdutos() {
		return CodigosProdutos;
	}
	public void setCodigosProdutos(List<Long> codigosProdutos) {
		CodigosProdutos = codigosProdutos;
	}
	
}
