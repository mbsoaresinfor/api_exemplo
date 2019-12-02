package br.com.mbs.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.mbs.entidades.Usuario;

@Service
public class UsuarioDaoImpl implements UsuarioDao {

	private Map<Integer,Usuario> mapaUsuario = new HashMap<Integer,Usuario>();
	private Integer id = new Integer(0);
	
	@Override
	public Integer salvarUsuario(Usuario usuario) {
		Integer novoId = ++id;
		mapaUsuario.put(novoId, usuario);
		return novoId;
	}

	@Override
	public List<Usuario> getUsuarios() {
		return new ArrayList(mapaUsuario.values());
	}

	@Override
	public Usuario getUsuario(Integer id) {		
		return mapaUsuario.get(id);
	}

	@Override
	public void deletaUsuario(Integer id) {
		mapaUsuario.remove(id);
	}

}
