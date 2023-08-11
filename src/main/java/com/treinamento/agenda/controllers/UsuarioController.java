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

import com.treinamento.agenda.entities.dto.UsuarioEntradaDto;
import com.treinamento.agenda.entities.dto.UsuarioSaidaDto;
import com.treinamento.agenda.services.UsuarioService;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	
	@GetMapping("{id}")
	public UsuarioSaidaDto encontrarUm(@PathVariable("id") Long id) {
		return service.encontrarUm(id);
	}
	
	
	@GetMapping
	public List<UsuarioSaidaDto> exibirUsuarios(){
		return service.exibirTodos();
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public UsuarioSaidaDto salvar(@Valid @RequestBody UsuarioEntradaDto usuarioEntradaDto) {
		
		return service.salvar(usuarioEntradaDto);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@PutMapping("{id}")
	public void alterar(@PathVariable("id")Long id, @Valid @RequestBody UsuarioEntradaDto usuarioEntradaDto) {
		service.alterar(id, usuarioEntradaDto);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void excluir(@PathVariable Long id) {
		
		service.excluir(id);
	}
	
}
