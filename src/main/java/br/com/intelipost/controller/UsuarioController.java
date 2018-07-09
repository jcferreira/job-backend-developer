package br.com.intelipost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.intelipost.business.UsuarioBusiness;
import br.com.intelipost.canonic.model.Usuario;
import br.com.intelipost.framework.exceptions.UsuarioNovoInvalidoException;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioBusiness usuarioBusiness;
	
	@PostMapping("/login_antigo")
	public String login(String email, String senha) {
//		usuarioBusiness.efetuarLogin(email, senha)
		return "listaUsuario";
	}

	@GetMapping("/cadastrar")
	public String telaCadastrar() {
		return "home";
	}

	@PostMapping("/cadastrar")
	public String cadastrar(String email, String nome, String senha, Model model) {
		try {
	        usuarioBusiness.criarLogin(new Usuario(email, nome, senha));
        } catch (UsuarioNovoInvalidoException e) {
	        model.addAttribute("msgErro", e.getMensagem());
        }
		return "home";
	}

	@GetMapping("/listar")
	public String listaUsuario(Model model) {
		return "listaUsuario";
	}


}
