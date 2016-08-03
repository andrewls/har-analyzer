/**
 * Created by andrew on 8/2/16.
 */

angular.module('harAnalyzer', ['harAnalyzer.controllers', 'harAnalyzer.services', 'harAnalyzer.directives', 'ui.router'])
    .config(function($stateProvider, $urlRouterProvider) {
    console.log("In the config function!");
    $stateProvider
        .state('home', {
            url: '/',
            templateUrl: 'partials/har-analyzer.html',
            controller: 'HarCtrl as har'
        });
    $urlRouterProvider.otherwise('/');
});

console.log("Application js ran");