package com.treinamento.agenda.entities.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UsuarioEntradaDto {
	
	@Pattern(regexp = "^[\\p{L} .'-]+[/^\\S+$/]+$")
	@NotEmpty(message = "campo obrigatório")
	private String nome;
	
	@Email
	@NotEmpty(message = "campo obrigatório")
	private String email;
	
	@NotEmpty(message = "campo obrigatório")
	private String senha;
	
	public UsuarioEntradaDto() {
		
	}

	public UsuarioEntradaDto(String nome, String email, String senha) {
		
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
		
}
