/**
 * 
 */
var url = "http://localhost:8484/exdoc/"
var app = angular.module('exdoc',['ngRoute','ngStorage','ui.bootstrap']);
app.config(['$routeProvider', function($routeProvider){
    $routeProvider
        .when('/',{	
        			template:'This is the default Route'
        		})
        .when('/borrowEntry',
        		{
        			templateUrl:'./app/borrow/views/entry.html',
        			controller:'borrowEntryCtrl'
        		})
        .when('/borrowList',
        		{
        			templateUrl:"./app/borrow/views/list.html",
        			controller:"borrowListCtrl"
        		})
        .otherwise({redirectTo:'/'});
}]);