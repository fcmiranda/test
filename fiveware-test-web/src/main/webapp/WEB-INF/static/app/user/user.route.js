(function () {
    'use strict';

    angular
        .module('app.user')
        .run(appRun);

    appRun.$inject = ['routerHelper'];
    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                state: 'user',
                config: {
                    url: '/',
                    templateUrl: 'static/app/user/user.html',
                    controller: 'UserController',
                    controllerAs: 'vm',
                    title: 'Usuários',
                    settings: {
                        nav: 1,
                        description: 'Cadastro de Usuário',
                        icon: 'person_add'
                    }
                }
            },
            {
                state: 'users',
                config: {
                    url: '/users',
                    templateUrl: 'static/app/user/user-list.html',
                    controller: 'UserListController',
                    controllerAs: 'vm',
                    title: 'Listagem de Usuários',
                    settings: {
                        nav: 2,
                        description: 'Listagem de usuários',
                        icon: 'people'
                    }
                }
            }
        ];
    }
})();
