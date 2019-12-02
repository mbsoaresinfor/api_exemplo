package br.com.mbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mbs.dao.UsuarioDao;
import br.com.mbs.entidades.Usuario;
import br.com.mbs.exception.EntidadeNaoEncontradaException;
import br.com.mbs.exception.ValidacaoException;
import br.com.mbs.validacao.ValidacaoUsuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private ValidacaoUsuario validacaoUsuario;
	
	@Override
	public Integer salvarUsuario(Usuario usuario) throws ValidacaoException {
		System.out.println("Salvando um usuario");
		if(usuario == null ) {
			throw new IllegalArgumentException("usuario esta null");
		}
		validacaoUsuario.valida(usuario);
		return usuarioDao.salvarUsuario(usuario);
	}

	@Override
	public List<Usuario> getUsuarios() {
		return usuarioDao.getUsuarios();
	}

	@Override
	public Usuario getUsuario(Integer id) throws EntidadeNaoEncontradaException {
		if(id == null ) {
			throw new IllegalArgumentException("id esta null");
		}
		Usuario usuario = usuarioDao.getUsuario(id);
		if(usuario == null) {
			throw new EntidadeNaoEncontradaException("Usuário com id " + id + " não encontrado");
		}
		return usuario;
	}

	@Override
	public void deletaUsuario(Integer id) throws EntidadeNaoEncontradaException {
		if(id == null ) {
			throw new IllegalArgumentException("id esta null");
		}
		Usuario usuario = usuarioDao.getUsuario(id);
		if(usuario == null) {
			throw new EntidadeNaoEncontradaException("Usuário com id " + id + " não encontrado");
		}
		
		usuarioDao.deletaUsuario(id);

	}

}
