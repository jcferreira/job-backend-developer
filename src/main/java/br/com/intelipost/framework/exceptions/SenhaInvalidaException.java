package br.com.intelipost.framework.exceptions;


public class SenhaInvalidaException extends Exception {

    private static final long serialVersionUID = 2688744592146866762L;
    
	private String mensagem;
    
    public SenhaInvalidaException(){
    	super();
    	this.mensagem = "";
    }
    
    public SenhaInvalidaException(String mensagem){
    	super(mensagem);
    	this.mensagem = mensagem;
    }
    
    public String getMensagem(){
    	return mensagem;
    }
}
