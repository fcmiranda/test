(function () {
    'use strict';

    angular
        .module('app.core')
        .service('CgBusyService', CgBusyService);

    CgBusyService.$inject = ['$mdToast'];

    function CgBusyService($mdToast) {
        return {
                getNew : function (){
                return {
                    promise:"",
                    message:'Carregando',
                    backdrop:true,
                    templateUrl:'static/app/core/busy.html',
                    delay:300,
                    minDuration:700
                };
            }
        };
    }

})();

