package br.com.roberto.produtosemarcas.ws.mapper;

import br.com.roberto.produtosemarcas.exception.PaginacaoMarcaInvalidaException;
import br.com.roberto.produtosemarcas.model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PaginacaoMarcaInvalidaExceptionMapper implements ExceptionMapper<PaginacaoMarcaInvalidaException> {

    @Override
    public Response toResponse(PaginacaoMarcaInvalidaException e) {

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(ErrorMessage.builder()
                        .addErro(e.getMessage())
                        .addStatusCode(Response.Status.BAD_REQUEST.getStatusCode())
                        .addStatusMessage(Response.Status.BAD_REQUEST.toString())
                        .build())
                .type(MediaType.APPLICATION_JSON)
                .build();

    }
}
