package br.com.roberto.produtosemarcas.ws.mapper;

import br.com.roberto.produtosemarcas.model.ErrorMessage;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException e) {

        return Response.status(Response.Status.NOT_FOUND)
                .entity(ErrorMessage.builder()
                        .addErro(e.getMessage())
                        .addStatusCode(e.getResponse().getStatus())
                        .addStatusMessage(e.getResponse().getStatusInfo().toString())
                        .build())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
