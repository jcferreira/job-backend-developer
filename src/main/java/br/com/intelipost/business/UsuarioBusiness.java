package br.com.intelipost.business;

import br.com.intelipost.canonic.model.Usuario;

public interface UsuarioBusiness {
	
	Usuario criarLogin(Usuario usuario);

	Usuario login(Usuario usuario);

}
