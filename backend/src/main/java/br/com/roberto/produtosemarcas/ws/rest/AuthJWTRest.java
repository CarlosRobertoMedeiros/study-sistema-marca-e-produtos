package br.com.roberto.produtosemarcas.ws.rest;

import br.com.roberto.produtosemarcas.exception.UsuarioNaoAutenticadoException;
import br.com.roberto.produtosemarcas.model.Usuario;
import br.com.roberto.produtosemarcas.service.UsuarioService;
import br.com.roberto.produtosemarcas.ws.jwt.JWTSecurityContext;
import br.com.roberto.produtosemarcas.ws.jwt.TokenJWTUtil;
import br.com.roberto.produtosemarcas.ws.jwt.UserDetails;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
public class AuthJWTRest {

    @Inject
    private UsuarioService usuarioService;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response autenticarUsuario(@FormParam("login") String login,
                                      @FormParam("password") String password){
        Usuario usuario = validarCredenciais(login,password);
        String token = TokenJWTUtil.gerarToken(usuario.getUsername(), usuario.recuperarRoles());

        return Response.ok()
                .header("Authorization","Bearer "+token)
                .build();
    }

    @POST
    @Path("refresh")
    @PermitAll
    public Response atualizarToken(@Context ContainerRequestContext requestContext) {
        JWTSecurityContext JWTSecurityContext = (JWTSecurityContext) requestContext.getSecurityContext();
        UserDetails userDetails = (UserDetails) JWTSecurityContext.getUserPrincipal();
        String token = TokenJWTUtil.gerarToken(userDetails.getName(), userDetails.getRoles());

        return Response.ok().header("Authorization", "Bearer " + token).build();
    }



    private Usuario validarCredenciais(String login, String password) {
        Usuario usuario = usuarioService.recuperarUsuarioComLoginESenha(login,password);

        if (usuario == null){
            throw  new UsuarioNaoAutenticadoException("Usuário Não autenticado. Nome do usuário ou senha inválido !!!");
        }

        return usuario;
    }



}
