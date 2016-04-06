/**
 * 
 */
app.controller('borrowEntryCtrl',function($scope,$http,$q)
		{
			$scope.init=function()
			{
				var promise = $scope.initPage();
				promise.then(function()
						{
					
						});
			};
			$scope.initPage=function()
			{
				
			};
		});