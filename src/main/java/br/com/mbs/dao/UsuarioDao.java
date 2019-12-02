package br.com.mbs.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mbs.entidades.Usuario;


public interface UsuarioDao {

	Integer salvarUsuario (Usuario usuario);

	List<Usuario> getUsuarios();

	Usuario getUsuario(Integer id);

	void deletaUsuario(Integer id);
}
