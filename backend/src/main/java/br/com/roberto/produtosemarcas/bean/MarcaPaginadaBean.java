package br.com.roberto.produtosemarcas.bean;

import br.com.roberto.produtosemarcas.model.Marca;
import br.com.roberto.produtosemarcas.model.Paginador;

import java.util.List;

public class MarcaPaginadaBean {

    private Paginador paginador;
    private List<Marca> marcas;

    public MarcaPaginadaBean(Paginador paginador, List<Marca> marcas) {
        this.paginador = paginador;
        this.marcas = marcas;
    }

    public Paginador getPaginador() {
        return paginador;
    }

    public void setPaginador(Paginador paginador) {
        this.paginador = paginador;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }
}
