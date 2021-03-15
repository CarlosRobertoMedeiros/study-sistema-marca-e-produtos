//http://damienfremont.github.io/blog/20151102-javaee-angularjs-bootstrap-pagination/
(function(){
    'use strict';
    
    angular
        .module('app')
        .controller('MarcaCntrl',['$http','MarcaService',MarcaCntrl]);

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
            mc.marca = {};
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
        };

        mc.buscarAnteriorPaginaServico = function(){
            let nuPagina = mc.paginaAtual -1;
            mc.buscarPaginaServico(nuPagina, mc.icTipoPessoa, mc.searchServico);
        };
        
        mc.buscarProximaPaginaServico = function(){
            let nuPagina = mc.paginaAtual +1;
            mc.buscarPaginaServico(nuPagina, mc.icTipoPessoa, mc.searchServico);
        };
        
        mc.buscarUltimaPaginaServico = function(){
            let nuPagina = mc.totalPagina;
            mc.buscarPaginaServico(nuPagina, mc.icTipoPessoa, mc.searchServico);
        };

        mc.visualizarMarca = function(marca){
            mc.marca = {};
            mc.marca = marca;
            $('#visualizarMarcaModal').modal('show');
        };

        mc.alterarMarca = function(marca){
            mc.marca = {};
            mc.marca = marca;
            $('#alterarMarcaModal').modal('show');
            $('#alterarMarcaModal').on('shown.bs.modal', function() {
                $(this).find('[autofocus]').focus();
              });
        };

        mc.excluirMarca = function(marca){  
            mc.marca = {};
            mc.marca = marca;
            $('#excluirMarcaModal').modal('show');

        };

        mc.excluirMarca2 = function(){
            debugger;
            marcaService.excluirMarca(mc.marca).then(function(response){
                mc.marcas = [];
                mc.marcas = response.data;
                console.log(response.data);
            }), function(error){
                debugger;
                if (error.data){
                    console.log(error);
                }
            }
        }

        mc.incluirMarca = function(){
            $('#incluirMarcaModal').modal('show');
            $('#incluirMarcaModal').on('shown.bs.modal', function() {
                $(this).find('[autofocus]').focus();
              });
        }

        mc.init = function(){
            this.iniciarObj();
            this.buscarPaginaServico(1);
        };
        
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
        };
    }
})();

