(function(){
    'use strict';

    angular
        .module('app')
        .service('ConfiguracaoService',[ConfiguracaoService]);

    function ConfiguracaoService(){
        const cs = this;
        cs.classBody = this.classBody;

        cs.configurarClassBody = function(classBody){
            cs.classBody = classBody;
        }

        cs.getClassBody = function(){
            return cs.classBody;
        }
    }



})();