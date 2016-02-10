(function () {
    'use strict';

    angular
        .module('app.user')
        .controller('UserListController', UserController);

    UserController.$inject = ['$q', '$location', 'UserService', 'CgBusyService'];

    /* @ngInject */
    function UserController($q, $location, UserService, CgBusyService) {
        var vm  = this;
        vm.busy = CgBusyService.getNew();
        vm.promise = UserService.getUsers();

        vm.busy.promise = vm.promise;
        vm.promise.then(function (response) {
            vm.users = response.data;
        });

    }

})();

