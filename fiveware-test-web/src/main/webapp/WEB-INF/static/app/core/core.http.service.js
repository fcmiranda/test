(function () {
    'use strict';

    angular
        .module('app.core')
        .service('HttpRequestService', HttpRequestService);

    HttpRequestService.$inject = ['$http', 'enviroment'];

    function HttpRequestService($http, enviroment) {
        return {
            get: get,
            put: put
        };

        function build(segments) {
            return enviroment.WEB_SERVICE_URL_PATH + segments.join("/");
        }

        function get(requestModel) {

            var url = build(requestModel.segments);
            requestModel.method = 'GET';

            return $http.get(url, requestModel).then(successCallback, errorCallback);

            function successCallback(response) {
                return response;
            }

            function errorCallback(response) {
                console.log('Ocorreu um erro');
                return response;
            }

        }

        function put(requestModel) {

            var url = build(requestModel.segments);
            var config = {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                }
            };

            return $http.put(url, requestModel.data, config).then(successCallback, errorCallback);

            function successCallback(response) {
                return response;
            }

            function errorCallback(response) {
                console.log('Ocorreu um erro');
                return response;
            }

        }
        }

    }

    )();

