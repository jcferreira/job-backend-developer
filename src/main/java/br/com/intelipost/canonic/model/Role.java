package br.com.intelipost.canonic.model;

import lombok.Data;

@Data
public class Role {

	public Role() { }
	
	public Role(String chaveAcesso) { 
		this.chaveAcesso = chaveAcesso;
	}
	
	private String chaveAcesso;
	
}
