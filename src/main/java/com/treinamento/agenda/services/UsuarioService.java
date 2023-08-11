package com.treinamento.agenda.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import com.treinamento.agenda.entities.Usuario;
import com.treinamento.agenda.entities.dto.UsuarioEntradaDto;
import com.treinamento.agenda.entities.dto.UsuarioSaidaDto;
import com.treinamento.agenda.exception.ErroDeNegocioException;
import com.treinamento.agenda.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	public UsuarioSaidaDto encontrarUm(Long id) {
		Optional<Usuario> optional = repository.findById(id);
		
		if(!optional.isPresent()) {
			throw new ErroDeNegocioException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
		}
		
		Usuario usuarioDb = optional.get();
		
		UsuarioSaidaDto saidaDto = mapper.map(usuarioDb, UsuarioSaidaDto.class);
		
		return saidaDto;
	}

	public List<UsuarioSaidaDto> exibirTodos() {
		
		List<Usuario> usuarios = repository.findAll();
		
		List<UsuarioSaidaDto> usuariosDto = mapper.map(usuarios, new TypeToken<List<UsuarioSaidaDto>>(){}.getType());
		
		return usuariosDto;
	}

	public UsuarioSaidaDto salvar(UsuarioEntradaDto usuarioEntradaDto) {
		try {
			Usuario usuario = mapper.map(usuarioEntradaDto, Usuario.class);
			
			Usuario usuarioDb = repository.save(usuario);
			
			UsuarioSaidaDto saidaDto = mapper.map(usuarioDb, UsuarioSaidaDto.class);
			
			return saidaDto;
			
		}catch(DataIntegrityViolationException e) {
			
			throw new ErroDeNegocioException(HttpStatus.BAD_REQUEST, "Usuário já cadastrado.");
		}
	}

	public void alterar(Long id, UsuarioEntradaDto novoUsuarioEntradaDto) {
		Optional<Usuario> optional = repository.findById(id);
		
		if(!optional.isPresent()) {
			throw new ErroDeNegocioException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
		}
		
		Usuario usuarioDb = optional.get();
		
		mapper.map(novoUsuarioEntradaDto, usuarioDb);
		
		repository.save(usuarioDb);
	}

	public void excluir(Long id) {
		
		if(!repository.existsById(id)) {
			throw new ErroDeNegocioException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
		}
		
		repository.deleteById(id);
	}
	
}
