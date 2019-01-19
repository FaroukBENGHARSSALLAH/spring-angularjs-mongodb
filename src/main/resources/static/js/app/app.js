

var app = angular.module('vidulumApp', ['ngRoute']);


   app.config(function ($routeProvider) {
				    $routeProvider
				        .when('/',
				            {
				        	    controller: 'HomeController',
				                templateUrl: '/vidulum/js/app/partials/home.html',
				            })
				            
				             .when('/option',
				            {
				                controller: 'optionController',
				                templateUrl: '/vidulum/js/app/partials/option.html'
				            })
				            
				         .when('/portfolio',
				            {
				                controller: 'portfolioController',
				                templateUrl: '/vidulum/js/app/partials/portfolio.html'
				            })
				           
				        .otherwise({ redirectTo: '/' });
           });




