(function () {
    'use strict';

    angular
        .module('app.core', [
            'ngAnimate', 'ngSanitize', 'ngLocale', 'cgBusy',
            'ngMaterial', 'ngMessages', 'ngMask',
            'blocks.exception', 'blocks.logger', 'blocks.router',
            'ui.router'
        ])
        .config(function($mdThemingProvider) {
            // Extend the red theme with a few different colors
            var appPink = $mdThemingProvider.extendPalette('pink', {
                '800': 'D61043'
            });
            // Register the new color palette map with the name <code>neonRed</code>
            $mdThemingProvider.definePalette('appPink', appPink);
            // Use that theme for the primary intentions
            $mdThemingProvider.theme('default')
                .primaryPalette('appPink', {
                    'default' : '800'
                })
        });

})();