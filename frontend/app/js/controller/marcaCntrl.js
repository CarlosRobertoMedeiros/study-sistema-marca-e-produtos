//http://damienfremont.github.io/blog/20151102-javaee-angularjs-bootstrap-pagination/
(function(){
    'use strict';
    angular.module('app').controller('MarcaCntrl',['$http','MarcaService',MarcaCntrl]);

    function MarcaCntrl($http,marcaService){
        const mc = this;   
        mc.titulo = "Titulo 102030";

        mc.iniciarObj = function() {
            mc.icPaginacao = false;
            mc.paginaAtual = 1;
            mc.icTipoPessoa = '';
            mc.searchServico = undefined;
            mc.nuPaginaExibicao = [];
            mc.servicos = [];
            mc.totalPagina = 0;
        };
        
        mc.prepareExibirPaginacao = function (servicos,nuPagina){
            mc.servicos = servicos;
            mc.nuPaginaExibicao = [];

            if(mc.servicos.paginador.qtPaginas > 0){
                mc.icPaginacao = true;
                for (let i =1; i<=mc.servicos.paginador.qtPaginas; i++){
                    mc.nuPaginaExibicao.push(i);
                }
                mc.paginaAtual = nuPagina;
            }

        };
        
        mc.buscarPaginaServico = function(nuPagina,icTipoPessoa,searchServico){

            //mc.openSession()
            debugger;
            marcaService.listarMarcas(nuPagina)
            //servicoService.buscarPaginaServico(nuPagina,mc.icTipoPessoa, mc.searchServico)
                .then(function(response) {
                        let servicos = response.data;
                        mc.prepareExibirPaginacao(servicos,nuPagina)
                        if(servicos != undefined && servicos != null){
                            if(servicos.marcas.length != undefined){
                                mc.totalPagina = servicos.paginador.qtPaginas;
                            }
                        }
                    },function(error){
                        console.log('error '+error)
                    }
                )
        };
        
        
        mc.buscarPrimeiraPaginaServico = function(){
            let nuPagina = 1;
			mc.buscarPaginaServico(nuPagina, mc.icTipoPessoa, mc.searchServico);
            console.log("Chamei o primeiro");
        };

        mc.buscarAnteriorPaginaServico = function(){
            let nuPagina = mc.paginaAtual -1;
            mc.buscarPaginaServico(nuPagina, mc.icTipoPessoa, mc.searchServico);
            console.log("Chamei o anterior");

        };
        
        mc.buscarProximaPaginaServico = function(){
            let nuPagina = mc.paginaAtual +1;
            mc.buscarPaginaServico(nuPagina, mc.icTipoPessoa, mc.searchServico);
            console.log("Chamei a proxima Pagina");

        };
        
        mc.buscarUltimaPaginaServico = function(){
            let nuPagina = mc.totalPagina;
            mc.buscarPaginaServico(nuPagina, mc.icTipoPessoa, mc.searchServico);
            console.log("Chamei a proxima Pagina");

        };


        /*


        mc.marcas = [];
        mc.paginaAtual = 1;
        mc.totalRegistrosPorPagina = 5;
        mc.tamanhoMaximo = 10;

        
        
        mc.icPaginacao=false;
        mc.nuPaginaExibicao = [];
        
        mc.totalItems = 50,
        
        
        mc.totalPages = Math.round(mc.totalItems / mc.totalRegistrosPorPagina);
        */

        /*
        mc.preparaExibicaoPaginacao = function(paginaAtual){
            mc.nuPaginaExibicao = [];
            if (mc.totalPages > 0){
                mc.icPaginacao=true;
                for(let i=1;i<=mc.totalPages;i++){
                    mc.nuPaginaExibicao.push(i);
                }
                mc.paginaAtual = paginaAtual;
            }
        }

        mc.buscarPrimeiraPagina = function(pagina){
            let primeiraPagina =1;
            console.log("primeira Pagina "+mc.paginaAtual);
        }

        mc.buscarProximaPagina = function(){
            mc.paginaAtual +=1;
            console.log("proxima pagina "+mc.paginaAtual);
        }

        mc.buscarUltimaPagina = function(){
            mc.totalPages;
            console.log("ultima pagina "+mc.totalPages);
        }

        mc.buscarPaginaAnterior = function(){
            mc.paginaAtual -=1;
            console.log("pagina anterior "+mc.paginaAtual);
        }
        */
        mc.init = function(){
            //this.prepareExibirPaginacao(1);
            this.buscarPaginaServico(1);
            
        }
        
        mc.listarMarcas = function (){
            marcaService.listarMarcas(mc.currentPage,mc.totalRegistros)
                .then(function(response){
                    mc.marcas = [];
                    mc.marcas = response.data;
                    console.log(response.data);
                }), function(error){
                    if (error.data){
                        console.log(error);
                    }
                }
        }
    }
})();

