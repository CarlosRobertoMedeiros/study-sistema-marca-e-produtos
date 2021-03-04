package br.com.roberto.produtosemarcas.ws.rest;

import br.com.roberto.produtosemarcas.bean.PaginacaoFilterBean;
import br.com.roberto.produtosemarcas.exception.PaginacaoMarcaInvalidaException;
import br.com.roberto.produtosemarcas.model.Marca;
import br.com.roberto.produtosemarcas.service.MarcaService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/marcas")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@RequestScoped
@PermitAll
public class MarcaRest {

    @Inject
    private MarcaService marcaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response recuperarMarcas(@BeanParam PaginacaoFilterBean paginacaoFilterBean,
                                    @QueryParam("nome") @DefaultValue("") String nome,
                                    @Context UriInfo uriInfo){
        if (nome.equals("") && paginacaoFilterBean.getTamanho()==0 && paginacaoFilterBean.getInicio()==0){
            throw new PaginacaoMarcaInvalidaException("Parâmetros informados incorretamente ! ");
        }

        try{
            List<Marca> marcas =  (nome.isEmpty()) ?
                    marcaService.recuperarMarcas(paginacaoFilterBean) :
                    marcaService.recuperarMarcasPorNome(nome);

            return  (marcas.isEmpty()) ? Response.noContent().build() : Response.ok(marcas).build();
        }catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("{marcaId}")
    public Response recuperarMarcaPorId(@PathParam("marcaId") long marcaId) {
        try {
            Marca marca = marcaService.recuperarMarcaPorId(marcaId);
            if (marca==null){
                return Response.noContent().build();
            }
            return Response.ok(marca).build();
        }catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("{marcaId}")
    @RolesAllowed({"Admin","Supervisor"})
    public Marca atualizarMarca(@PathParam("marcaId") long marcaId, Marca marca) {
        marcaService.atualizarMarca(marca, marcaId);
        return marca;
    }

    @DELETE
    @Path("{marcaId}")
    @RolesAllowed({"Admin"})
    public void excluirMarca(@PathParam("marcaId") long marcaId) {
        marcaService.excluirMarca(marcaId);
    }

//    @Path("{marcaId}/produtos")
//    public ProdutoRest obterProdutoResource() {
//        return new ProdutoRest();
//    }

    @POST
    @Path("{marcaId}/produtos")
    public Response salvarMarca(Marca marca, @Context UriInfo uriInfo) {
        marcaService.salvarMarca(marca);

        return Response
                .created(uriInfo.getAbsolutePathBuilder().path(Long.toString(marca.getId())).build())
                .entity(marca)
                .build();

    }

}
