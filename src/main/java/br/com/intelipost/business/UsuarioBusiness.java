package br.com.intelipost.business;

import br.com.intelipost.canonic.model.Usuario;
import br.com.intelipost.framework.exceptions.UsuarioNovoInvalidoException;

public interface UsuarioBusiness {
	
	Usuario criarLogin(Usuario usuario) throws UsuarioNovoInvalidoException;

}
