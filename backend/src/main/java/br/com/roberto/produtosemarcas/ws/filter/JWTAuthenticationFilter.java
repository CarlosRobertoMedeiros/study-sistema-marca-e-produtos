package br.com.roberto.produtosemarcas.ws.filter;


import br.com.roberto.produtosemarcas.exception.UsuarioNaoAutenticadoException;
import br.com.roberto.produtosemarcas.ws.jwt.JWTSecurityContext;
import br.com.roberto.produtosemarcas.ws.jwt.KeyGenerator;
import br.com.roberto.produtosemarcas.ws.jwt.TokenJWTUtil;
import br.com.roberto.produtosemarcas.ws.jwt.UserDetails;
import br.com.roberto.produtosemarcas.ws.rest.AuthJWTRest;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Key;
import java.util.List;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class JWTAuthenticationFilter implements ContainerRequestFilter {

    private KeyGenerator keyGenerator = new KeyGenerator();

    @Context
    private UriInfo uriInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader != null && authorizationHeader.contains("Bearer ")) {
            String token = authorizationHeader.substring("Bearer".length()).trim();

            Key key = keyGenerator.generateKey();

            if (TokenJWTUtil.tokenValido(token, key)) {
                String nome = TokenJWTUtil.recuperarNome(token, key);
                List<String> roles = TokenJWTUtil.recuperarRoles(token, key);
                UserDetails userDetails = new UserDetails(nome, roles);

                boolean secure = requestContext.getSecurityContext().isSecure();
                requestContext.setSecurityContext(new JWTSecurityContext(userDetails, secure));
                return;

            }
        } else if (acessoParaLoginNaAPI(requestContext)) {
            return;
        } else if (acessoParaMetodosDeConsulta(requestContext)) {
            return;
        }
        throw new UsuarioNaoAutenticadoException("Token inválido/expirado ou usuário não autenticado");
    }

    private boolean acessoParaLoginNaAPI(ContainerRequestContext requestContext) {
        return requestContext.getUriInfo().getAbsolutePath().toString()
                .equals(uriInfo.getBaseUriBuilder().path(AuthJWTRest.class).build().toString());
    }


    private boolean acessoParaMetodosDeConsulta(ContainerRequestContext requestContext) {
        return "GET".equalsIgnoreCase(requestContext.getMethod());
    }


}
