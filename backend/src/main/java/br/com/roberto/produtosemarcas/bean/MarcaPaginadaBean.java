package br.com.roberto.produtosemarcas.bean;

import br.com.roberto.produtosemarcas.model.Marca;
import br.com.roberto.produtosemarcas.model.Paginador;

import java.util.List;

public class MarcaPaginadaBean {

    private List<Marca> marcas;
    private Paginador paginador;

    public MarcaPaginadaBean(List<Marca> marcas, Paginador paginador) {
        this.marcas = marcas;
        this.paginador = paginador;
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
