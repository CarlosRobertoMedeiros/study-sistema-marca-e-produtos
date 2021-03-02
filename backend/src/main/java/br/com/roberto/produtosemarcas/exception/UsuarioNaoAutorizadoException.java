package br.com.roberto.produtosemarcas.exception;

public class UsuarioNaoAutorizadoException extends RuntimeException {

    public UsuarioNaoAutorizadoException(String message) {
        super(message);
    }
}
