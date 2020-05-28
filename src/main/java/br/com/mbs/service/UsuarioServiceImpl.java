package br.com.mbs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mbs.entidades.Usuario;
import br.com.mbs.exception.EntidadeNaoEncontradaException;
import br.com.mbs.exception.ValidacaoException;
import br.com.mbs.repository.UsuarioRepository;
import br.com.mbs.validacao.ValidacaoUsuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioDao;
	@Autowired
	private ValidacaoUsuario validacaoUsuario;
	
	@Override
	public Integer salvarUsuario(Usuario usuario) throws ValidacaoException {
		System.out.println("Salvando o usuario " + usuario);
		
		validacaoUsuario.valida(usuario);
		Usuario usuarioFromDb =  usuarioDao.save(usuario);
		return  (int) usuarioFromDb.getId();
	}

	@Override
	public List<Usuario> getUsuarios() {
		System.out.println("Buscando todos os usuarios");
		List<Usuario> retorno = new ArrayList<Usuario>();
		Iterable<Usuario> it =  usuarioDao.findAll();
		it.forEach(u -> retorno.add(u));
		return retorno;
	}

	@Override
	public Usuario getUsuario(Integer id) throws EntidadeNaoEncontradaException {
		System.out.println("Buscando o usuario com id= " + id);
		if(id == null ) {
			throw new IllegalArgumentException("id esta null");
		}
		Optional<Usuario> optUsuario = usuarioDao.findById((long)id);
	
		if(optUsuario.isPresent()== false) {
			throw new EntidadeNaoEncontradaException("Usuário com id " + id + " não encontrado");
		}
		return optUsuario.get();
	}

	@Override
	public void deletaUsuario(Integer id) throws EntidadeNaoEncontradaException {
		System.out.println("Deletando o usuario com id= " + id);
		if(id == null ) {
			throw new IllegalArgumentException("id esta null");
		}
		Optional<Usuario> optUsuario  = usuarioDao.findById((long)id);
		if(optUsuario.isPresent()== false) {
			throw new EntidadeNaoEncontradaException("Usuário com id " + id + " não encontrado");
		}
		
		usuarioDao.deleteById((long)id);

	}

	@Override
	public void atualizaUsuario(Usuario usuario) throws ValidacaoException {
		System.out.println("atualizando o usuario " + usuario);
						
		validacaoUsuario.valida(usuario);
		usuarioDao.save(usuario);		
		
	}

}
