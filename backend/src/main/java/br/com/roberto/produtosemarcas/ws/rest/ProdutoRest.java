package br.com.roberto.produtosemarcas.ws.rest;

import br.com.roberto.produtosemarcas.model.Produto;
import br.com.roberto.produtosemarcas.service.ProdutoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/produto")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ProdutoRest {

    @Inject
    private ProdutoService produtoService;

    @Path("/{marcaId}")
    @POST
    public Response salvarProduto(@PathParam("marcaId") long marcaId, Produto produto, @Context UriInfo uriInfo) {
        produtoService.salvarProduto(produto, marcaId);

        return Response
                .created(uriInfo.getAbsolutePathBuilder().path(Long.toString(produto.getId())).build())
                .entity(produto)
                .build();
    }

    @Path("/{marcaId}")
    @GET
    public List<Produto> recuperarProdutos(@PathParam("marcaId") long marcaId,
                                           @QueryParam("nome") @DefaultValue("") String nome) {
        return (nome.isEmpty()) ? produtoService.recuperarProdutos(marcaId) : produtoService.recuperarProdutosPorNome(marcaId, nome);
    }

    @Path("{produtoId}")
    @GET
    public Produto recuperarProdutoPorId(@PathParam("marcaId") long marcaId, @PathParam("produtoId") long produtoId) {
        return produtoService.recuperarProdutoPorId(marcaId, produtoId);
    }

    @Path("{produtoId}")
    @PUT
    public Produto atualizarProduto(@PathParam("marcaId") long marcaId, @PathParam("produtoId") long produtoId, Produto produto) {
        produtoService.atualizarProduto(marcaId, produtoId, produto);
        return produto;
    }

    @Path("{produtoId}")
    @DELETE
    public void excluirProduto(@PathParam("produtoId") long produtoId) {
        produtoService.excluirProduto(produtoId);
    }



}
