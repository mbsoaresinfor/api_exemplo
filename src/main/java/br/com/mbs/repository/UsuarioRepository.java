package br.com.mbs.repository;




import org.springframework.data.repository.CrudRepository;
import br.com.mbs.entidades.Usuario;


public interface UsuarioRepository  extends CrudRepository<Usuario, Long> {

	
}
