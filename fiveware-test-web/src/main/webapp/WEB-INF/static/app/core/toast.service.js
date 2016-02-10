(function () {
    'use strict';

    angular
        .module('app.core')
        .service('ToastService', ToastService);

    ToastService.$inject = ['$mdToast'];

    function ToastService($mdToast) {
        return {
            show: function (text) {
                return $mdToast.show(
                        $mdToast.simple()
                            .textContent(text)
                            .position("top")
                            .hideDelay(1500)
                );
            }
        };
    }

})();

