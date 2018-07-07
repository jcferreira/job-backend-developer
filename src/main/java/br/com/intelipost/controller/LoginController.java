package br.com.intelipost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.intelipost.business.UsuarioBusiness;

@Controller
@RequestMapping("/usuario")
public class LoginController {

	@Autowired
	private UsuarioBusiness usuarioBusiness;
	
	@GetMapping("/login")
	public void criar() {
		
	}

	@PostMapping("/login")
	public void login() {
//		usuarioBusiness.efetuarLogin(email, senha)
	}

}
