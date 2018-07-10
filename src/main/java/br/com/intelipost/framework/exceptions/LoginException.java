package br.com.intelipost.framework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoginException extends RuntimeException {

    private static final long serialVersionUID = 4931260994429540164L;
    
	private String mensagem;
    
    public LoginException(){
    	super();
    	this.mensagem = "";
    }
    
    public LoginException(String mensagem){
    	super(mensagem);
    	this.mensagem = mensagem;
    }
    
    public String getMensagem(){
    	return mensagem;
    }
}
