package br.com.roberto.produtosemarcas.ws.mapper;

import br.com.roberto.produtosemarcas.exception.UsuarioNaoAutorizadoException;
import br.com.roberto.produtosemarcas.model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UsuarioNaoAutorizadoExceptionMapper implements ExceptionMapper<UsuarioNaoAutorizadoException> {

    @Override
    public Response toResponse(UsuarioNaoAutorizadoException e) {

        return Response.status(Response.Status.FORBIDDEN)
                .entity(ErrorMessage.builder()
                        .addErro(e.getMessage())
                        .addStatusCode(Response.Status.FORBIDDEN.getStatusCode())
                        .addStatusMessage(Response.Status.FORBIDDEN.toString())
                        .build())
                .type(MediaType.APPLICATION_JSON)
                .build();

    }
}
