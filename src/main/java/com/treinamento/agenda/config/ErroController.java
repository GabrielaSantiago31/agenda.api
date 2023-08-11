package com.treinamento.agenda.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.treinamento.agenda.entities.dto.ErroDto;
import com.treinamento.agenda.exception.ErroDeNegocioException;
import com.treinamento.agenda.exception.LoginException;

@RestControllerAdvice
public class ErroController{
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(ErroDeNegocioException.class)
	@ResponseBody
	public ResponseEntity<ErroDto> handle(ErroDeNegocioException e){
		ErroDto erroDto = new ErroDto();
		erroDto.setErro(e.getErro());
		
		return ResponseEntity.status(e.getHttpStatus()).body(erroDto);
	}
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	@ResponseBody
	public ErroDto handle(BindException exception) {
		List<String> validacoes = new ArrayList<>();
		
		for(FieldError error : exception.getBindingResult().getFieldErrors()) {
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			validacoes.add(error.getField() + ": " + mensagem);
		}
		
		ErroDto erroDto = new ErroDto();
		erroDto.setErro("Verifique os campos");
		erroDto.setValidacoes(validacoes);
		
		return erroDto;
	}
	
	
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	@ExceptionHandler(LoginException.class)
	@ResponseBody
	public ErroDto handle(LoginException exception) {		
		ErroDto erroDto = new ErroDto();
		erroDto.setErro(exception.getMessage());
		erroDto.setValidacoes(new ArrayList<>());
		
		return erroDto;
	}	
	
	
}
