package br.com.intelipost.framework.exceptions;


public class UsuarioNovoInvalidoException extends Exception {

    private static final long serialVersionUID = -5890674712551694852L;
    
	private String mensagem;
    
    public UsuarioNovoInvalidoException(){
    	super();
    	this.mensagem = "";
    }
    
    public UsuarioNovoInvalidoException(String mensagem){
    	super(mensagem);
    	this.mensagem = mensagem;
    }
    
    public String getMensagem(){
    	return mensagem;
    }
}
