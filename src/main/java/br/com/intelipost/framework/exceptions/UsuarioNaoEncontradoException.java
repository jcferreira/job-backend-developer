package br.com.intelipost.framework.exceptions;


public class UsuarioNaoEncontradoException extends Exception {

    private static final long serialVersionUID = -8805514626480869450L;

    private String mensagem;
    
    public UsuarioNaoEncontradoException(){
    	super();
    	this.mensagem = "";
    }
    
    public UsuarioNaoEncontradoException(String mensagem){
    	super(mensagem);
    	this.mensagem = mensagem;
    }
    
    public String getMensagem(){
    	return mensagem;
    }
}
