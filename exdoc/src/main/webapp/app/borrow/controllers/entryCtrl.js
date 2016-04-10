/**
 * 
 */
app.controller('borrowEntryCtrl',function($scope,$http,$q,commonService,borrowService,$routeParams)
		{
			$scope.departments=[];
			$scope.branches=[];
			$scope.positions=[];
			$scope.objectives=[];
			$scope.model={};
			$scope.id = $routeParams.id;
			
			$scope.init=function()
			{
				if($scope.id==null || $scope.id==undefined)
				{
							$scope.id=0;
				}
			
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
				    		commonService.getAllBorrowObjective(),
				    		borrowService.getByKey($scope.id)
				    ]).then(function(data)
				    		{
				    			
				    				$scope.departments=data[0].data.list;
				    				$scope.branches=data[1].data.list;
				    				$scope.positions=data[2].data.list;
				    				$scope.objectives=data[3].data.list;

				    				$scope.model =data[4].data;
				    				$scope.model.id=$scope.id;
				    				if($scope.model.id>0)
				    				{
				    					$scope.model.borrowBy = commonService.getObject($scope.model.borrowBy);
				    					$scope.model.reviewBy = commonService.getObject($scope.model.reviewBy);
				    					$scope.model.approveBy= commonService.getObject($scope.model.approveBy);
				    					$scope.model.branch = commonService.getObject($scope.model.branch);
				    					$scope.model.department =commonService.getObject($scope.model.department);
				    					$scope.model.position = commonService.getObject($scope.model.position);
				    					$scope.model.borrowDate =commonService.getDate($scope.model.borrowDate);
				    					$scope.model.reviewDate = commonService.getDate($scope.model.reviewDate);
				    					$scope.model.approveDate = commonService.getDate($scope.model.approveDate);
				    					

				    				}
				    				deferred.resolve(data);
				    		});
				  return promise;
			};
			$scope.save=function()
			{
				borrowService.save($scope.model).success(function(res)
						{
							alert("success");
						});
			};
		});