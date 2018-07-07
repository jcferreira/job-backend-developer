package br.com.intelipost.business;

import br.com.intelipost.canonic.model.Usuario;
import br.com.intelipost.framework.exceptions.SenhaInvalidaException;
import br.com.intelipost.framework.exceptions.UsuarioNaoEncontradoException;

public interface UsuarioBusiness {
	
	Usuario efetuarLogin(String email, String senha) throws UsuarioNaoEncontradoException, SenhaInvalidaException;

	Usuario criarLogin(Usuario usuario);

}
