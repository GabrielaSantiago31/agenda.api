package com.treinamento.agenda.entities.dto;

public class ContatoSaidaDto {
	
	private Long id;
	
	private String nome;
	private String telefone;
	private String rg;
	private String email;
	private String tipo;
	
	public ContatoSaidaDto() {
		
	}
	
	public ContatoSaidaDto(Long id, String nome, String telefone, String rg, String email, String tipo) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.rg = rg;
		this.email = email;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
