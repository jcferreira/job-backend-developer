package br.com.intelipost.canonic.model;

import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class Usuario {

	public Usuario() {}
	
	public Usuario(String email, String nome, String senha) {
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.ativo = Boolean.TRUE;
		this.permissoes = Arrays.asList(new Role("ROLE_ADMIN"));
	}
	
	private String email;
	
	private String nome;
	
	private String senha;
	
	private boolean ativo;
	
	private List<Role> permissoes;
	
}
