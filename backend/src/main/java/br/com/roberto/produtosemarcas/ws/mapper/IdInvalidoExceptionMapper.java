package br.com.roberto.produtosemarcas.ws.mapper;

import br.com.roberto.produtosemarcas.exception.IdInvalidoException;
import br.com.roberto.produtosemarcas.model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class IdInvalidoExceptionMapper implements ExceptionMapper<IdInvalidoException> {

    @Override
    public Response toResponse(IdInvalidoException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(ErrorMessage.builder()
                        .addErro(exception.getMessage())
                        .addStatusCode(Response.Status.BAD_REQUEST.getStatusCode())
                        .addStatusMessage(Response.Status.BAD_REQUEST.toString())
                        .build())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
