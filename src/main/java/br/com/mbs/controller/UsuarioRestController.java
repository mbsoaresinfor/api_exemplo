package br.com.mbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.mbs.entidades.Usuario;
import br.com.mbs.exception.EntidadeNaoEncontradaException;
import br.com.mbs.exception.ValidacaoException;
import br.com.mbs.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@RestController(value="API para manipulacao de usuarios")
public class UsuarioRestController {
	
	@Autowired
	 private UsuarioService pessoaService;

	 
	 @ApiOperation(value = "Salva um usuario",response=Integer.class)
	 @ApiResponses(value = {
			    @ApiResponse(code = 200, message = "Sucesso ao salvar o usuario"),			    
			    @ApiResponse(code = 405, message = "Usuario com problema na validacao"),
			})
	 @RequestMapping(value = "/usuarios", method = RequestMethod.POST, produces="application/json")	 
	 public ResponseEntity<Integer> salvarUsuario(@RequestBody Usuario usuario) throws Exception{
		 ResponseEntity<Integer> ret = null;
		 try {
			 ret =  new ResponseEntity<>( pessoaService.salvarUsuario(usuario),HttpStatus.OK);
		 }catch(ValidacaoException e) {
			 ret = ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
		 }
		 return ret;
	  }
	    
	 @ApiOperation(value = "Retorna uma lista de usuarios",response=Usuario.class,responseContainer="List")
	 @ApiResponses(value = {
			    @ApiResponse(code = 200, message = "Sucesso no retorno da lista de usuarios")			   
			})	 
	 @RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces="application/json")
	  public List<Usuario> getUsuarios() {
	    return pessoaService.getUsuarios();
	  }
	 
	 @ApiOperation(value = "Retorna um usuario",response=Usuario.class)
	 @ApiResponses(value = {
			    @ApiResponse(code = 200, message = "Sucesso no retorno do usuario"),
			    @ApiResponse(code = 404, message = "Usuario nao encontrado"),
			})
	 @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET, produces="application/json")	 
	  public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id) throws Exception {
		 ResponseEntity<Usuario> responseEntity;
		 try {
			 responseEntity =  new ResponseEntity<>( pessoaService.getUsuario(id),HttpStatus.OK);			 
		 }catch( EntidadeNaoEncontradaException e) {
			 responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return responseEntity;
	  }
	 
	 
	 @ApiOperation(value = "Deleta um usuario")
	 @ApiResponses(value = {
			    @ApiResponse(code = 200, message = "Sucesso na remocao do usuario"),
			    @ApiResponse(code = 404, message = "Usuario nao encontrado"),			  
			})	 
	 @DeleteMapping("/usuarios/{id}")
	 public ResponseEntity<Void> deletaUsuario(@PathVariable Integer id) throws Exception {
		 ResponseEntity<Void> responseEntity;
		 try {
			  pessoaService.deletaUsuario(id);	
			  responseEntity = ResponseEntity.ok().build();
		 }catch( EntidadeNaoEncontradaException e) {
			 responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return responseEntity;
	  }
	 
	 
	 @ApiOperation(value = "Atualiza um usuario")
	 @ApiResponses(value = {
			    @ApiResponse(code = 200, message = "Sucesso na atualizacao do usuario"),
			    @ApiResponse(code = 405, message = "Problema na validacao do Usuario "),			  
			})	 
	 @RequestMapping(value = "/usuarios", method = RequestMethod.PUT, produces="application/json")	 
	 public ResponseEntity<Void> atualizaUsuario(@RequestBody Usuario usuario) throws Exception{
		 ResponseEntity<Void> ret = null;
		 try {
			 pessoaService.atualizaUsuario(usuario);
			 ret = ResponseEntity.ok().build();;
		 }catch(ValidacaoException e) {
			 ret = ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
		 }
		 return ret;
	  }
	
}
