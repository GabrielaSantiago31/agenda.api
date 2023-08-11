package com.treinamento.agenda.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.treinamento.agenda.entities.Contato;
import com.treinamento.agenda.entities.dto.ContatoEntradaDto;
import com.treinamento.agenda.entities.dto.ContatoSaidaDto;
import com.treinamento.agenda.exception.ErroDeNegocioException;
import com.treinamento.agenda.repositories.ContatoRepository;


@Service	
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	public ContatoSaidaDto encontrarUm(Long id) {
		Optional<Contato> optional = repository.findById(id);
		
		if(!optional.isPresent()) {
			throw new ErroDeNegocioException(HttpStatus.NOT_FOUND, "Contato não encontrado.");
		}
		
		Contato contatoDb = optional.get();
		
		ContatoSaidaDto saidaDto = mapper.map(contatoDb, ContatoSaidaDto.class);
		
		return saidaDto;
	}

	public List<ContatoSaidaDto> exibirTodos() {
		
		List<Contato> contatos = repository.findAll();
		
		List<ContatoSaidaDto> contatosDto = mapper.map(contatos, new TypeToken<List<ContatoSaidaDto>>(){}.getType());
		
		return contatosDto;
	}

	public ContatoSaidaDto salvar(ContatoEntradaDto contatoEntradaDto) {
		try {
			Contato contato = mapper.map(contatoEntradaDto, Contato.class);
			
			Contato contatoDb = repository.save(contato);
			
			ContatoSaidaDto saidaDto = mapper.map(contatoDb, ContatoSaidaDto.class);
			
			return saidaDto;
			
		}catch(DataIntegrityViolationException e) {
			
			throw new ErroDeNegocioException(HttpStatus.BAD_REQUEST, "Contato já cadastrado.");
		}
		
	}

	public void alterar(Long id, ContatoEntradaDto novoContatoEntradaDto) {
		Optional<Contato> optional = repository.findById(id);
		
		if(optional.isEmpty()) {
			throw new ErroDeNegocioException(HttpStatus.NOT_FOUND, "Contato não encontrado.");
		}
		
		Contato contatoDb = optional.get();
		
		mapper.map(novoContatoEntradaDto, contatoDb);
		
		repository.save(contatoDb);
	}

	public void excluir(Long id) {
		
		if(!repository.existsById(id)) {
			throw new ErroDeNegocioException(HttpStatus.NOT_FOUND, "Contato não encontrado.");
		}
		
		repository.deleteById(id);
	}
	
}
