/**
 * 
 */
var loginApp = angular.module('loginApp',['ngStorage']);
loginApp.controller('loginCtrl',function($scope,$http, $location, $localStorage,$rootScope)
{
	$scope.model={};
	$scope.login=function()
	{
	
				   $.ajax({
					   url: 'j_spring_security_check?ajax=true',
	                    method: 'POST',
	                    dataType: 'json',
	                    data: {
	                        //do_login: true,
	                        username: $scope.model.username,
	                        password: $scope.model.password
	                    }, // serializes the form's elements.
			           success: function(data)
			           {
			        	   $localStorage.authenData = data;
			               $scope.$apply();
			               if (data.username) {
			                   $rootScope.authenticated = true;
			               } else {
			                   $rootScope.authenticated = false;
			               }
			               window.location="/index.html";
			           }
			         });

	};
});
