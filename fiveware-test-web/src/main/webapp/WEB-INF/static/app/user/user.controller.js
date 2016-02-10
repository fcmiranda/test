(function () {
    'use strict';

    angular
        .module('app.user')
        .controller('UserController', UserController);

    UserController.$inject = ['$timeout', '$scope', '$location', 'UserService', 'ToastService', 'CgBusyService'];

    /* @ngInject */
    function UserController($timeout, $scope, $location, UserService, ToastService, CgBusyService) {
        var vm = this;

        vm.busy = CgBusyService.getNew();
        vm.showHints = true;
        vm.user = {
            active: true
        };

        $scope.$watch("vm.user.area", function (newVal, oldVal) {
            if (newVal != oldVal) {
                vm.user.skills = [];
            }
        });

        UserService.getAreas().then(function (response) {
            vm.areas = response.data;
        });

        vm.save = function () {
            vm.promise = UserService.save(vm.user);
            vm.busy.promise = vm.promise;
            vm.promise.then(
                function (response) {
                    ToastService.show(response.data.message);
                    $timeout(function () {
                        $location.path("/users");
                    },2000);
                },
                function () {
                    ToastService.show("Ocorreu um erro ao salvar.");
                }
            );
        };

        vm.toggle = function (item, list) {
            var idx = list.indexOf(item);
            if (idx > -1) list.splice(idx, 1);
            else list.push(item);
        };
        vm.exists = function (item, list) {
            return list.indexOf(item) > -1;
        };

    }

})();

