package br.com.roberto.produtosemarcas.bean;

import javax.ws.rs.QueryParam;

public class PaginacaoFilterBean {
    private @QueryParam("inicio")
    int inicio;
    private @QueryParam("tamanho")
    int tamanho;

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
