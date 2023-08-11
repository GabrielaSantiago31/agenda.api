package com.treinamento.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.agenda.entities.Usuario;
import com.treinamento.agenda.exception.LoginException;
import com.treinamento.agenda.repositories.UsuarioRepository;

@Service
public class LoginService {
	
	@Autowired
	private UsuarioRepository repository;

	
	public void logIn(String email, String senha) {

		List<Usuario> lista = repository.findAllByEmail(email);
		
		if(lista.isEmpty()) {
			throw new LoginException("Usuário inválido");
		}
		
		Usuario usuario = lista.get(0);
		
		if(!usuario.getSenha().equals(senha)) {
			throw new LoginException("Senha inválida");
		}
	}
	
}
