package br.com.intelipost.business.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intelipost.business.UsuarioBusiness;
import br.com.intelipost.canonic.model.Usuario;
import br.com.intelipost.framework.exceptions.SenhaInvalidaException;
import br.com.intelipost.framework.exceptions.UsuarioNaoEncontradoException;
import br.com.intelipost.integration.domain.UsuarioLogin;
import br.com.intelipost.integration.repository.LoginRepository;

@Service
public class UsuarioBusinessImpl implements UsuarioBusiness {

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
    public Usuario efetuarLogin(String email, String senha) throws UsuarioNaoEncontradoException, SenhaInvalidaException {
		UsuarioLogin usuarioLogin = loginRepository.findByEmailAndAtivoTrue(email);
		validarLogin(senha, usuarioLogin);
	    return new ModelMapper().map(usuarioLogin, Usuario.class);
    }
	
	public Usuario criarLogin(Usuario usuario) {
		UsuarioLogin usuarioLogin = loginRepository.save(new ModelMapper().map(usuario, UsuarioLogin.class));
		return new ModelMapper().map(usuarioLogin, Usuario.class);
	}
	
	private void validarLogin(String senha, UsuarioLogin usuarioLogin) throws UsuarioNaoEncontradoException, SenhaInvalidaException {
		if (usuarioLogin == null) throw new UsuarioNaoEncontradoException("Usuario não encontrado!");
		if (!senha.equals(usuarioLogin.getSenha())) throw new SenhaInvalidaException("Senha inválida!");
	}
	
}
