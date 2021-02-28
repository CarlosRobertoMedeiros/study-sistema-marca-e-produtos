package br.com.roberto.produtosemarcas.ws.mapper;

import br.com.roberto.produtosemarcas.exception.UsuarioNaoAutenticadoException;
import br.com.roberto.produtosemarcas.model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class UsuarioNaoAutenticadoExceptionMapper implements ExceptionMapper<UsuarioNaoAutenticadoException> {

    @Override
    public Response toResponse(UsuarioNaoAutenticadoException e) {

        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(ErrorMessage.builder()
                        .addErro(e.getMessage())
                        .addStatusCode(Response.Status.UNAUTHORIZED.getStatusCode())
                        .addStatusMessage(Response.Status.UNAUTHORIZED.toString())
                        .build())
                .type(MediaType.APPLICATION_JSON)
                .build();


    }
}
