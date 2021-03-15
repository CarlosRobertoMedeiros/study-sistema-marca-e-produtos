(function(){
    'use strict';

    angular
        .module('app')
        .factory('AutenticacaoService',AutenticacaoService);

    function AutenticacaoService($http, $localStorage){
        const authService = this;   
        const baseUrl = 'http://localhost:8086/backend-sistema-marcas-e-produtos-1.0-SNAPSHOT';
        const versao = '/v1';
        
        authService.Login = Login;
        authService.Logout = Logout;

        return authService;

        function Login(usuario, senha, callback){
            $http.post(baseUrl+versao+'/auth', {username: username, password: password})
                .success(function (response){

                    if (response.token){
                        $localStorage.currentUser = {username: username, password: password};
                        $http.defaults.headers.common.Authorization = 'Bearer ' + response.token;
                        callback(true);
                    }else{
                        callback(false);
                    }

                });
        }

        function Logout(){
            delete $localStorage.currentUser;
            $http.defaults.headers.common.Authorization = '';    
        }

    }

})();