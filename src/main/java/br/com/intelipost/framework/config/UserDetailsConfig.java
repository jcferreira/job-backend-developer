package br.com.intelipost.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.intelipost.integration.domain.UsuarioLogin;
import br.com.intelipost.integration.repository.LoginRepository;

@Repository
public class UserDetailsConfig implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UsuarioLogin usuarioLogin = loginRepository.findByEmailAndAtivoTrue(email);
		validarLogin(usuarioLogin);
	    return usuarioLogin;
    }

	private void validarLogin(UsuarioLogin usuarioLogin) {
		if (usuarioLogin == null) 
			throw new UsernameNotFoundException("Usuario não encontrado!");
	}
	
}
