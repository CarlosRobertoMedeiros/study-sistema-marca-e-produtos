package br.com.roberto.produtosemarcas.ws.rest;

import br.com.roberto.produtosemarcas.model.Produto;
import br.com.roberto.produtosemarcas.service.ProdutoService;

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

    private final ProdutoService produtoService = new ProdutoService();

    @POST
    public Response salvarProduto(@PathParam("marcaId") long marcaId, Produto produto, @Context UriInfo uriInfo) {
        produtoService.salvarProduto(produto, marcaId);

        return Response
                .created(uriInfo.getAbsolutePathBuilder().path(Long.toString(produto.getId())).build())
                .entity(produto)
                .build();
    }

    @GET
    public List<Produto> recuperarProdutos(@PathParam("marcaId") long marcaId, @QueryParam("nome") @DefaultValue("") String nome) {
        return (nome.isEmpty()) ? produtoService.recuperarProdutos(marcaId) : produtoService.recuperarProdutosPorNome(marcaId, nome);
    }

    @GET
    @Path("{produtoId}")
    public Produto recuperarProdutoPorId(@PathParam("marcaId") long marcaId, @PathParam("produtoId") long produtoId) {
        return produtoService.recuperarProdutoPorId(marcaId, produtoId);
    }

    @PUT
    @Path("{produtoId}")
    public Produto atualizarProduto(@PathParam("marcaId") long marcaId, @PathParam("produtoId") long produtoId, Produto produto) {
        produtoService.atualizarProduto(marcaId, produtoId, produto);
        return produto;
    }

    @DELETE
    @Path("{produtoId}")
    public void excluirProduto(@PathParam("produtoId") long produtoId) {
        produtoService.excluirProduto(produtoId);
    }



}
