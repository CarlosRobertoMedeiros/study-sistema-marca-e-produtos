package br.com.roberto.produtosemarcas.exception;

public class EntidadeNaoExisteException extends  RuntimeException{

    public EntidadeNaoExisteException(String message) {
        super(message);
    }
}
