package com.treinamento.agenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.agenda.entities.Usuario;
import com.treinamento.agenda.services.LoginService;


@RestController
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	
	@PostMapping
	public void logIn(@RequestBody Usuario usuario) {
		
		service.logIn(usuario.getEmail(), usuario.getSenha());
	}
	
}
