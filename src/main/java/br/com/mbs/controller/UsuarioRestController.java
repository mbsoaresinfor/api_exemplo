package br.com.mbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.mbs.entidades.Usuario;
import br.com.mbs.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@RestController(value="API para manipução de usuários")
public class UsuarioRestController {
	
	@Autowired
	 private UsuarioService pessoaService;

	 
	 @ApiOperation(value = "Salva um usuário",response=Integer.class)
	 @ApiResponses(value = {
			    @ApiResponse(code = 200, message = "Sucesso ao salvar o usuário"),			    
			    @ApiResponse(code = 405, message = "Usuário com problema na validação"),
			})
	 @RequestMapping(value = "/usuarios", method = RequestMethod.POST, produces="application/json")	 
	 public Integer salvarUsuario(@RequestBody Usuario usuario) throws Exception{
	    	return pessoaService.salvarUsuario(usuario);
	  }
	    
	 @ApiOperation(value = "Retorna uma lista de usuários",response=Usuario.class,responseContainer="List")
	 @ApiResponses(value = {
			    @ApiResponse(code = 200, message = "Sucesso no retorno da lista de usuários")			   
			})	 
	 @RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces="application/json")
	  public List<Usuario> getUsuarios() {
	    return pessoaService.getUsuarios();
	  }
	 
	 @ApiOperation(value = "Retorna um usuário",response=Usuario.class)
	 @ApiResponses(value = {
			    @ApiResponse(code = 200, message = "Sucesso no retorno do usuário"),
			    @ApiResponse(code = 404, message = "Usuário não encontrado"),
			    @ApiResponse(code = 405, message = "Id inválido"),
			})
	 @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET, produces="application/json")	 
	  public Usuario getUsuario(@PathVariable Integer id) throws Exception {
	    return pessoaService.getUsuario(id);
	  }
	 
	 
	 @ApiOperation(value = "Deleta um usuário")
	 @ApiResponses(value = {
			    @ApiResponse(code = 200, message = "Sucesso na remoção do usuário"),
			    @ApiResponse(code = 404, message = "Usuário não encontrado"),
			    @ApiResponse(code = 405, message = "Id inválido"),
			})	 
	 @DeleteMapping("/usuarios/{id}")
	 public void deletaUsuario(@PathVariable Integer id) throws Exception {
		 pessoaService.deletaUsuario(id);
	  }
	
}
