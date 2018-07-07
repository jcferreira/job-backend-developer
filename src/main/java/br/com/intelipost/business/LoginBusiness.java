package br.com.intelipost.business;

import br.com.intelipost.canonic.model.Usuario;

public interface LoginBusiness {
	
	Usuario login(String email, String senha);

}
