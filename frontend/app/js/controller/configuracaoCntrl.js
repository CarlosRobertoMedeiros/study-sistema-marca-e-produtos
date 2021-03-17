(function(){
    'use strict';

    angular
        .module('app')
        .controller('ConfiguracaoCntrl',['ConfiguracaoService',ConfiguracaoCntrl]);
    
    function ConfiguracaoCntrl(configuracaoService){
        const cc = this;

        cc.init = function(){
            configuracaoService.configurarClassBody('servicos');
        };

        cc.classBody = function(){
            return configuracaoService.getClassBody();
        }

        cc.init();

    }


})();