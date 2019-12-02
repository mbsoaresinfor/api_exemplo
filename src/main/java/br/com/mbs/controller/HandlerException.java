package br.com.mbs.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.mbs.exception.EntidadeNaoEncontradaException;
import br.com.mbs.exception.ValidacaoException;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class HandlerException {

	@ResponseBody
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String EntidadeNaoEncontradaHandler(Exception ex) {
	    return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	String IllegalArgumentExceptionHandler(Exception ex) {
	    return ex.getMessage();
	}
	@ResponseBody
	@ExceptionHandler(ValidacaoException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	String ValidacaoExceptionHandler(Exception ex) {
	    return ex.getMessage();
	}
	
}
