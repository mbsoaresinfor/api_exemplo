package br.com.mbs.entidades;

import java.io.Serializable;

public class Usuario implements Serializable{

	
	private static final long serialVersionUID = -4021164211840850744L;
	
	private String nome;	
	private String email;
	private String senha;
	private Integer status;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}
