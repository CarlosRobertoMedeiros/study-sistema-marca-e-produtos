(function(){
    'use strict';
    angular.module('app').service('MarcaService',['$http',MarcaService]);

    function MarcaService($http){
        const mc = this; 
        mc.classBody;  

        const baseUrl = 'http://localhost:8086/backend-sistema-marcas-e-produtos-1.0-SNAPSHOT/';
        const baseVersao = 'v1/';

        mc.listarMarcas = function(inicio,tamanho){
            const url = baseUrl+baseVersao+'marcas?inicio='+(inicio-1)+'&tamanho='+(tamanho);
            console.log(url);

            return $http.get(url);
        }
    
    }

})();
