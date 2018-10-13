"use strict";
var app = angular.module('app', ['ui.router']);

app.config(function($stateProvider, $urlRouterProvider){
    // For any unmatched url, send to /business
    $urlRouterProvider.otherwise('/');
     
    $stateProvider
            .state('default', {
                url: '/default',
                templateUrl: './partials/english.html',
                controller: 'MainController'
            })
            .state('italian', {
            	url: '/italian',
                templateUrl: './partials/italian.html',
                controller: 'SecondaryController'
            });
});

app.controller('MainController', function($scope) {
	$scope.yourName = "";
	$scope.greeting = "Hello";
});

app.controller('SecondaryController', function($scope) {
	$scope.yourName = "";
	$scope.greeting = "Ciao";
});




