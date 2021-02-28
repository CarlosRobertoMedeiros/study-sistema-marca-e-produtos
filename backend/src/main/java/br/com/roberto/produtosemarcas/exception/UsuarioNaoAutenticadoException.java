package br.com.roberto.produtosemarcas.exception;

public class UsuarioNaoAutenticadoException extends RuntimeException{

    public UsuarioNaoAutenticadoException(String message) {
        super(message);
    }
}
