package br.com.intelipost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.intelipost.business.UsuarioBusiness;
import br.com.intelipost.canonic.model.Usuario;

@Controller
@RequestMapping("/usuario")
public class LoginController {

	@Autowired
	private UsuarioBusiness usuarioBusiness;
	
	@PostMapping("/login")
	public String login(String email, String senha) {
//		usuarioBusiness.efetuarLogin(email, senha)
		return "home";
	}

	@PostMapping("/cadastrar")
	public String cadastrar(String email, String nome, String senha) {
		Usuario usuario = new Usuario(email, nome, senha);
		usuarioBusiness.criarLogin(usuario);
		return "home";
	}

}
