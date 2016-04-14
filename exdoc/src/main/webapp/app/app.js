/**
 * 
 */
var url = "http://localhost:8484/exdoc/";
var app = angular.module('exdoc',['ngStorage','ngRoute','ui.bootstrap']);
app.constant('config',
{

	pageSize : 10,
	maxSize : 10

	});
app.factory("$pageUtil",function()
{
	var factory = {};
	factory.getPage=function(page)
	{
		if(!page)
		{
			page = 1;
		}
		if(page==null || page == undefined)
		{
			page =1;
		}
		if(page==0)
		{
			page=1;
		}
		return page;
			
	}
	return factory;
});
app.run(function($rootScope) {

});
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
        .when('/depositEntry',
        		{
        			templateUrl:"./app/deposit/views/entry.html",
        			controller:"depositEntryCtrl"
        		})
        .when('/depositList',
        		{
        			templateUrl:"./app/deposit/views/list.html",
        			controller:"depositListCtrl"
        		})
        .when('/userEntry',
        		{
        			templateUrl:"./app/user/views/entry.html",
        			controller:"userEntryCtrl"
        		})
        .when('/userList',
        		{
        			templateUrl:"./app/user/views/list.html",
        			controller:"userListCtrl"
        		})
        .otherwise({redirectTo:'/'});
}])
.controller('mainCtrl',function($scope,$http,$localStorage)
		{
				$scope.init=function()
				{
					
				}
		});