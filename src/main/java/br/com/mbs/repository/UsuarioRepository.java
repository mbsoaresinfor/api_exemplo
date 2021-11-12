package br.com.mbs.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.expression.spel.support.ReflectivePropertyAccessor.OptimalPropertyAccessor;
import org.springframework.stereotype.Repository;
import br.com.mbs.entidades.Usuario;

@Repository
public class UsuarioRepository   {


	private HashMap<Long,Usuario> mapaUsuarios = new HashMap<Long,Usuario>();
	private static long contador = 1;
	
	public long salvar(Usuario usuario) {
		usuario.setId(contador);
		mapaUsuarios.put(contador, usuario);
		return contador++;
	}
	
	public Optional<Usuario>  buscar(Long id) {
		return Optional.ofNullable(mapaUsuarios.get(id));
		
	}
	
	public List<Usuario> listar(){
		return new ArrayList<Usuario>(mapaUsuarios.values());
	}
	
	public void remover(Long id) {
		mapaUsuarios.remove(id);
	}
	
	public void atualizar(Long id, Usuario usuario) {
		mapaUsuarios.put(id, usuario);
	}
}
