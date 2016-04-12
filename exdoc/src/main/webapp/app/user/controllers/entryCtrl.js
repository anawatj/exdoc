/**
 * 
 */
app.controller('userEntryCtrl',function($scope,$q,$location,$routeParams,commonService,userService)
		{
			$scope.model={id:0};
			$scope.id= $routeParams.id;
			$scope.init=function()
			{
					if($scope.id==null || $scope.id==undefined)
					{
						$scope.id=0;
					}
					
			}
		});