package br.com.roberto.produtosemarcas.model;

public class Paginador {

    public static final int QT_REGISTROS_POR_PAGINA = 5;
    private long qtPaginas;
    private long totalRegistros;
    private long paginaAtual;

    public Paginador(long qtPaginas, long totalRegistros, long paginaAtual) {
        this.qtPaginas = qtPaginas;
        this.totalRegistros = totalRegistros;
        this.paginaAtual = paginaAtual;
    }

    public static int getQtRegistrosPorPagina() {
        return QT_REGISTROS_POR_PAGINA;
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
