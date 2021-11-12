package br.com.mbs.validacao;

import org.springframework.stereotype.Component;

import br.com.mbs.entidades.Usuario;
import br.com.mbs.exception.ValidacaoException;



@Component
public class ValidacaoUsuario {

	public void valida(Usuario usuario) throws ValidacaoException {
		
		if(usuario == null) {
			throw new ValidacaoException("Usuario null");
		}
		
		if("".equals(usuario.getNome())) {
			throw new ValidacaoException("Nome do usuario não pode estar em branco");
		}
		if("".equals(usuario.getEmail())) {
			throw new ValidacaoException("Email do usuario não pode estar em branco");
		}
		if("".equals(usuario.getSenha())) {
			throw new ValidacaoException("Senha do usuario não pode estar em branco");
		}
		
	}
}
