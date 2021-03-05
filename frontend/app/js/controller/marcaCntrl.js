//http://damienfremont.github.io/blog/20151102-javaee-angularjs-bootstrap-pagination/
(function(){
    'use strict';
    angular.module('app').controller('MarcaCntrl',['$http','MarcaService',MarcaCntrl]);

    function MarcaCntrl($http,marcaService){
        const mc = this;   
        mc.marcas = [];
        mc.titulo = "Titulo 102030";
        
        mc.totalItems = 165,
        mc.currentPage = 1;
        mc.totalRegistros = 50;
      
        mc.pageChanged = function(){
            console.log('Pagina Corrente' +mc.currentPage);
        }

        
        mc.init = function(){
            this.listarMarcas();
        }
        
        mc.listarMarcas = function (){
            
            marcaService.listarMarcas(mc.inicio,mc.tamanho)
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
