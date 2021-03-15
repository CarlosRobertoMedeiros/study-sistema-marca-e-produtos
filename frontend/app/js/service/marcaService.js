(function(){
    'use strict';
    
    angular
        .module('app')
        .service('MarcaService',['$http',MarcaService]);

    function MarcaService($http){
        const mc = this; 
        mc.classBody;  

        const baseUrl = 'http://localhost:8086/backend-sistema-marcas-e-produtos-1.0-SNAPSHOT/';
        const baseVersao = 'v1/';

        mc.listarMarcas = function(inicio,tamanho){
            //const url = baseUrl+baseVersao+'marcas?inicio='+(inicio-1)+'&tamanho='+(tamanho);
            const url = baseUrl+baseVersao+'marcas?inicio='+(inicio-1)*5+'&tamanho='+5;
            console.log(url);

            return $http.get(url);
        }

        mc.excluirMarca = function (marca){
            debugger;
            const authToken = sessionStorage.getItem('authToken');
            const url = baseUrl+baseVersao+'marcas/'+marca.id;
            return $http({
                method: "DELETE",
                headers: new HttpHeaders({
                    'Content-type': 'application/json;charset=utf-8',
                    Authorization: 'Bearer '+ authToken
                }),
                url: url,
                data: marca,
                
            });
        }
    }
})();
