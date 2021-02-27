package br.com.roberto.produtosemarcas.ws.mapper;


import br.com.roberto.produtosemarcas.exception.EntidadeNaoExisteException;
import br.com.roberto.produtosemarcas.model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class EntidadeNaoExisteExceptionMapper implements ExceptionMapper<EntidadeNaoExisteException>{

    @Override
    public Response toResponse(EntidadeNaoExisteException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(ErrorMessage.builder()
                        .addErro(exception.getMessage())
                        .addStatusCode(Response.Status.NOT_FOUND.getStatusCode())
                        .addStatusMessage(Response.Status.NOT_FOUND.toString())
                        .build())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
