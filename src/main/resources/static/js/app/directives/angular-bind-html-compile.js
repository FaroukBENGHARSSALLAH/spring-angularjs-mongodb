		
// AngularJS defined directive, parse Article's body HTML content


      (function (angular) {
		       'use strict';
		       var module = angular.module('angular-bind-html-compile', []);
		       module.directive('bindHtmlCompile', ['$compile', function ($compile) {
				        return {
					            restrict: 'A',
					            link: function (scope, element, attrs) {
					                scope.$watch(function () {
					                          return scope.$eval(attrs.bindHtmlCompile);
					                     }, function (value) {
					                                 element.html(value && value.toString());
					                                 var compileScope = scope;
								                     if (attrs.bindHtmlScope) {
								                                 compileScope = scope.$eval(attrs.bindHtmlScope);
								                             }
					                                 $compile(element.contents())(compileScope);
					                            });
					                      }
				                 };
		              }]);
		}(window.angular));