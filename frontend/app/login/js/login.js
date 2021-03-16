(function(){
    'use strict';

    angular
        .module('app')
        .controller('Login.IndexController',Controller);
    
    function Controller($location, AutenticacaoService){
        const vm = this;
        vm.login = login;

        initController();

        function initController(){
            AutenticacaoService.Logout();    
        }

        function login(){
            vm.loading = true;
            AutenticacaoService.Login(vm.username, vm.password, function(result){
                if (result === true){
                    $location.path('/');
                }else{
                    vm.error = 'O usuário ou senha estão inválidos';
                    vm.loading = false;
                }
            });

        };
    }
})();