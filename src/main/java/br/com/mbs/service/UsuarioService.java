package br.com.mbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mbs.entidades.Usuario;
import br.com.mbs.exception.EntidadeNaoEncontradaException;
import br.com.mbs.exception.ValidacaoException;


public interface UsuarioService {

	Long salvarUsuario (Usuario usuario) throws ValidacaoException;

	List<Usuario> getUsuarios();

	Usuario getUsuario(Integer id) throws EntidadeNaoEncontradaException;

	void deletaUsuario(Integer id) throws EntidadeNaoEncontradaException;

	void atualizaUsuario(Usuario usuario) throws ValidacaoException,EntidadeNaoEncontradaException;
}
