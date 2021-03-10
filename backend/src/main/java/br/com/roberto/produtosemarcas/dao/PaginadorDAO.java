package br.com.roberto.produtosemarcas.dao;

import br.com.roberto.produtosemarcas.model.Paginador;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PaginadorDAO {

    public Paginador recuperaInformacoesMarcas( ) {
        EntityManager em = JPAUtil.getEntityManager();

        String jpqlQtdeMarcas =  "select count(m.nome) from Marca m";
        Query query = em.createQuery(jpqlQtdeMarcas);

        long qtdeMarcas = (long) query.getSingleResult();
        long qtdePaginas = Math.round((qtdeMarcas / 5));

        //TODO Ajustar a Página atual
        return new Paginador(qtdePaginas,qtdeMarcas,1);
    }

}
