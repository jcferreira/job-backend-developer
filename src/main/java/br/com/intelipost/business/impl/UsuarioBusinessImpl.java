package br.com.intelipost.business.impl;

import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intelipost.business.UsuarioBusiness;
import br.com.intelipost.canonic.model.Usuario;
import br.com.intelipost.framework.exceptions.UsuarioNovoInvalidoException;
import br.com.intelipost.integration.domain.UsuarioLogin;
import br.com.intelipost.integration.repository.LoginRepository;

@Service
public class UsuarioBusinessImpl implements UsuarioBusiness {

	@Autowired
	private LoginRepository loginRepository;
	
	public Usuario criarLogin(Usuario usuario) throws UsuarioNovoInvalidoException{
		validarUsuario(usuario);
		UsuarioLogin usuarioLogin = loginRepository.save(new ModelMapper().map(usuario, UsuarioLogin.class));
		return new ModelMapper().map(usuarioLogin, Usuario.class);
	}
	
	private void validarUsuario(Usuario usuario) throws UsuarioNovoInvalidoException {
		if (usuario == null || StringUtils.isBlank(usuario.getNome()) || 
				StringUtils.isBlank(usuario.getEmail()) || StringUtils.isBlank(usuario.getSenha()) ) 
			throw new UsuarioNovoInvalidoException("É necessário o preenchimento de todos os campos para realizar o cadastro de usuário!");
	}
	
}
