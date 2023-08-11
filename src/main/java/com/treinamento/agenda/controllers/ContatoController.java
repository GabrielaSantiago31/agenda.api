package com.treinamento.agenda.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.agenda.entities.dto.ContatoEntradaDto;
import com.treinamento.agenda.entities.dto.ContatoSaidaDto;
import com.treinamento.agenda.services.ContatoService;

@RestController
@RequestMapping("contatos")
public class ContatoController {
	

	@Autowired
	private ContatoService service;
	
	@GetMapping("{id}")
	public ContatoSaidaDto encontrarUm(@PathVariable("id") Long id) {
		
		return service.encontrarUm(id);	
	}
	
	@GetMapping
	public List<ContatoSaidaDto> exibirContatos(){
		
		return service.exibirTodos();
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public ContatoSaidaDto salvar(@Valid @RequestBody ContatoEntradaDto contatoEntradaDto) {
		
		return service.salvar(contatoEntradaDto);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@PutMapping("{id}")
	public void alterar(@PathVariable("id")Long id, @Valid @RequestBody ContatoEntradaDto contatoEntradaDto) {
		
		service.alterar(id, contatoEntradaDto);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void excluir(@PathVariable Long id) {
		
		service.excluir(id);
	}
}
