/* global toastr:false, moment:false */
(function() {
    'use strict';

    angular
        .module('app.core')
        .constant('toastr', toastr)
        .constant('moment', moment)
        .constant('enviroment', {
            WEB_SERVICE_URL_PATH: 'http://localhost:8080/api/'
        })

})();
