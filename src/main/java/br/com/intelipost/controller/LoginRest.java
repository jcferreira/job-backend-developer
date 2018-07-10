package br.com.intelipost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.intelipost.business.UsuarioBusiness;
import br.com.intelipost.canonic.model.Usuario;

@RestController
@RequestMapping("/auth/usuario")
public class LoginRest {

	@Autowired
	private UsuarioBusiness usuarioBusiness;
	
	@GetMapping("/login")
	public Usuario login(@RequestHeader String email, @RequestHeader String senha) {
		return usuarioBusiness.login(new Usuario(email, senha));
	}

}
