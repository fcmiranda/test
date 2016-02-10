(function () {
    'use strict';

    angular
        .module('app.user')
        .service('UserService', UserService);

    UserService.$inject = ['HttpRequestService'];

    function UserService(HttpRequestService) {
        return {
            getAreas: function () {
                return HttpRequestService.get(
                    {
                        segments: ["area", "list"]
                    }
                );
            },
            getUsers: function () {
                return HttpRequestService.get(
                    {
                        segments: ["user", "list"]
                    }
                );
            },
            save: function (user) {
                return HttpRequestService.put(
                    {
                        segments: ["user"],
                        data: user
                    }
                );
            }
        };
    }

})();

