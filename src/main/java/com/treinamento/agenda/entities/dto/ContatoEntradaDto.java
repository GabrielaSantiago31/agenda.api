package com.treinamento.agenda.entities.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ContatoEntradaDto {
	
	@Pattern(regexp = "^[\\p{L} .'-]+[/^\\S+$/]+$")
	@NotEmpty(message = "campo obrigatório")
	private String nome;
	
	@Size(min=10, max=11, message = "cuidado com a quantidade de caracteres!")
	@NotEmpty(message = "campo obrigatório")
	private String telefone;
	
	@NotEmpty
	private String rg;
	
	@Email(message = "email inválido")
	@NotEmpty(message = "campo obrigatório")
	private String email;
	
	@NotEmpty(message = "campo obrigatório")
	private String tipo;
	
	public ContatoEntradaDto() {
		
	}

	public ContatoEntradaDto(String nome, String telefone, String rg, String email, String tipo) {

		this.nome = nome;
		this.telefone = telefone;
		this.rg = rg;
		this.email = email;
		this.tipo = tipo;
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
