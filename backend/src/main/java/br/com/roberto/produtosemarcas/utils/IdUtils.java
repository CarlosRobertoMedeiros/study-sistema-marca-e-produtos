package br.com.roberto.produtosemarcas.utils;

import br.com.roberto.produtosemarcas.exception.IdInvalidoException;

public class IdUtils {
    public static Long idValido(Long id) {
        if (id <= 0) {
            throw new IdInvalidoException("Id inválido. Deve ser número inteiro maior que zero.");
        }
        return id;
    }
}
