(function () {
    'use strict';

    angular
        .module('app.core')
        .filter('thousandSuffix', function () {
            return function (input, decimals) {
                var exp, rounded,
                    suffixes = ['k', 'M', 'G', 'T', 'P', 'E'];

                if (window.isNaN(input)) {
                    return null;
                }

                if (input < 1000) {
                    return input;
                }

                exp = Math.floor(Math.log(input) / Math.log(1000));

                return (input / Math.pow(1000, exp)).toFixed(decimals) + suffixes[exp - 1];
            };
        })
        .filter('cpf', function() {
            return function(input) {
                var str = input+ '';
                str = str.replace(/\D/g,'');
                str = str.replace(/(\d{3})(\d)/,"$1.$2");
                str = str.replace(/(\d{3})(\d)/,"$1.$2");
                str = str.replace(/(\d{3})(\d{1,2})$/,"$1-$2");
                return str;
            };
        });
})();