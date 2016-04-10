/**
 * 
 */
app.controller('borrowEntryCtrl',function($scope,$http,$q,commonService,borrowService)
		{
			$scope.departments=[];
			$scope.branches=[];
			$scope.positions=[];
			$scope.objectives=[];
			$scope.model={};
			
			$scope.init=function()
			{
				var promise = $scope.initPage();
				promise.then(function()
						{
					
						});
			};
			$scope.initPage=function()
			{
				  var deferred = $q.defer();
				  var promise =$q.all
				  ([
				    
				    		commonService.getAllDepartment(),
				    		commonService.getAllBranch(),
				    		commonService.getAllPosition(),
				    		commonService.getAllBorrowObjective()
				    ]).then(function(data)
				    		{
				    			
				    				$scope.departments=data[0].data.list;
				    				$scope.branches=data[1].data.list;
				    				$scope.positions=data[2].data.list;
				    				$scope.objectives=data[3].data.list;
				    				deferred.resolve(data);
				    		});
				  return promise;
			};
		});