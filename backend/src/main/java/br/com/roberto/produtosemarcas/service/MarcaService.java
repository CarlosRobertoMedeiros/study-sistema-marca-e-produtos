package br.com.roberto.produtosemarcas.service;

import br.com.roberto.produtosemarcas.bean.MarcaPaginadaBean;
import br.com.roberto.produtosemarcas.bean.PaginacaoFilterBean;
import br.com.roberto.produtosemarcas.dao.JPAUtil;
import br.com.roberto.produtosemarcas.dao.MarcaDAO;
import br.com.roberto.produtosemarcas.dao.PaginadorDAO;
import br.com.roberto.produtosemarcas.model.Marca;
import br.com.roberto.produtosemarcas.model.Paginador;
import br.com.roberto.produtosemarcas.utils.IdUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class MarcaService {

    private final MarcaDAO marcaDAO = new MarcaDAO();
    private final PaginadorDAO paginadorDAO = new PaginadorDAO();

    public void salvarMarca(Marca marca) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            marcaDAO.salvarMarca(marca, em);
            if (marca.getProdutos() != null) {
                marca.getProdutos()
                        .parallelStream()
                        .forEach(marca::addProdutoToMarca);
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public MarcaPaginadaBean recuperarMarcas() {
        Paginador paginador = paginadorDAO.recuperaInformacoesMarcas();
        List<Marca> marcas = marcaDAO.recuperarMarcas();
        return new MarcaPaginadaBean(marcas,paginador);
    }

    public MarcaPaginadaBean recuperarMarcas(PaginacaoFilterBean paginacaoFilterBean) {
        Paginador paginador = paginadorDAO.recuperaInformacoesMarcas();
        List<Marca> marcas = marcaDAO.recuperarMarcas(paginacaoFilterBean);
        return new MarcaPaginadaBean(marcas,paginador);
    }


    public Marca recuperarMarcaPorId(long marcaId) {
        EntityManager em = JPAUtil.getEntityManager();
        return marcaDAO.recuperarMarcaPorId(IdUtils.idValido(marcaId), em);
    }

    public MarcaPaginadaBean recuperarMarcasPorNome(String nome) {
        return new MarcaPaginadaBean(marcaDAO.recuperarMarcasPorNome(nome),null);
    }

    public void atualizarMarca(Marca marca, long marcaId) {
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        marca.setId(IdUtils.idValido(marcaId));
        marcaDAO.recuperarMarcaPorId(marcaId, em);
        marcaDAO.atualizarMarca(marca, em);
        em.getTransaction().commit();
    }

    public void excluirMarca(long marcaId) {
        marcaDAO.excluirMarca(IdUtils.idValido(marcaId));
    }
}
