package br.com.intelipost.business.impl;

import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intelipost.business.UsuarioBusiness;
import br.com.intelipost.canonic.model.Usuario;
import br.com.intelipost.framework.exceptions.LoginException;
import br.com.intelipost.framework.exceptions.UsuarioNovoInvalidoException;
import br.com.intelipost.integration.domain.UsuarioLogin;
import br.com.intelipost.integration.repository.LoginRepository;

@Service
public class UsuarioBusinessImpl implements UsuarioBusiness {

	@Autowired
	private LoginRepository loginRepository;
	
	public Usuario criarLogin(Usuario usuario) {
		validarUsuario(usuario);
		UsuarioLogin usuarioLogin = loginRepository.save(new ModelMapper().map(usuario, UsuarioLogin.class));
		return new ModelMapper().map(usuarioLogin, Usuario.class);
	}
	
	public Usuario login(Usuario usuario) {
		validarDadosLogin(usuario);
		UsuarioLogin usuarioLogin = loginRepository.findByEmailAndSenhaAndAtivoTrue(usuario.getEmail(), usuario.getSenha());
		validarResultadoLogin(usuarioLogin);
		return new ModelMapper().map(usuarioLogin, Usuario.class);
	}
	
	private void validarUsuario(Usuario usuario) {
		if (usuario == null || StringUtils.isBlank(usuario.getNome()) || 
				StringUtils.isBlank(usuario.getEmail()) || StringUtils.isBlank(usuario.getSenha()) ) 
			throw new UsuarioNovoInvalidoException("É necessário o preenchimento de todos os campos para realizar o cadastro de usuário!");
	}
	
	private void validarDadosLogin(Usuario usuario) {
		if (usuario == null) throw new LoginException("Não foi informado login e senha!");
		if (StringUtils.isBlank(usuario.getEmail()) ) throw new LoginException("Email não informado!");
		if (StringUtils.isBlank(usuario.getSenha()) ) throw new LoginException("Senha não informado!");
	} 

	private void validarResultadoLogin(UsuarioLogin usuarioLogin) {
		if (usuarioLogin == null) throw new LoginException("Login ou senha inválido!");
	} 

}
