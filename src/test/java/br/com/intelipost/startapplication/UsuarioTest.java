package br.com.intelipost.startapplication;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.intelipost.business.UsuarioBusiness;
import br.com.intelipost.canonic.model.Usuario;

@SpringBootTest
public class UsuarioTest {

	@Mock
	private UsuarioBusiness usuarioBusiness;
	private Usuario usuario;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        usuario = new Usuario("teste@teste.com.br", "Julio", "1234");
	}
	
	@Test
	public void criarUsuarioComSucesso() {
		Usuario usuarioNovo = new Usuario();
		when(usuarioBusiness.criarLogin(usuario)).thenReturn(usuarioNovo);
	}

}
