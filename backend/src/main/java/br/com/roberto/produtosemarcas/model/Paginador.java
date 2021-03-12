package br.com.roberto.produtosemarcas.model;

public class Paginador {

    private long qtPaginas;
    private long totalRegistros;
    private long paginaAtual;
    private long qtRegistroPorPagina = 5;

    public Paginador(long qtPaginas, long totalRegistros, long paginaAtual, long qtRegistroPorPagina) {
        this.qtPaginas = qtPaginas;
        this.totalRegistros = totalRegistros;
        this.paginaAtual = paginaAtual;
        this.qtRegistroPorPagina = qtRegistroPorPagina;
    }

    public long getQtRegistroPorPagina() {
        return qtRegistroPorPagina;
    }

    public void setQtRegistroPorPagina(long qtRegistroPorPagina) {
        this.qtRegistroPorPagina = qtRegistroPorPagina;
    }

    public long getQtPaginas() {
        return qtPaginas;
    }

    public void setQtPaginas(long qtPaginas) {
        this.qtPaginas = qtPaginas;
    }

    public long getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(long totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

    public long getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(long paginaAtual) {
        this.paginaAtual = paginaAtual;
    }
}
