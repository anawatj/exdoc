/**
 * 
 */
app.controller('depositEntryCtrl',function($scope,$http,$q,commonService,depositService,$routeParams)
		{
				$scope.model={};
				$scope.departments=[];
				$scope.branches=[];
				$scope.positions=[];
				$scope.objectives=[];
				$scope.documentGroups=[];
				$scope.documentModes=[];
				$scope.documentTypes=[];
				$scope.id=$routeParams.id;
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
					  var promise = $q.all
					  (
						[
						 		commonService.getAllBranch(),
						 		commonService.getAllDepartment(),
						 		commonService.getAllPosition(),
						 		commonService.getAllDepositObjective(),
						 		commonSerivce.getAllDocumentGroup(),
						 		commonService.getAllDocumentMode(),
						 		commonSerivce.getAllDocumentType(),
						 		depositService.getByKey($scope.id)
						]
					  ).then(function(data)
							  {
						  			$scope.branches=data[0].data.list;
						  			$scope.departments=data[1].data.list;
						  			$scope.positions=data[2].data.list;
						  			$scope.objectives=data[3].data.list;
						  			$scope.documentGroups=data[4].data.list;
						  			$scope.documentModes=data[5].data.list;
						  			$scope.documentTypes =data[6].data.list;
						  			$scope.model=data[7].data;
						  			deferred.resolve(data);
							  })	;
					  
					  return promise;
				};
				$scope.addItem=function()
				{
					
				};
				$scope.delItem=function()
				{
					
				};
				$scope.findBorrowBy=function()
				{
					
				};
				$scope.findReviewBy=function()
				{
					
				};
				$scope.findApproveBy=function()
				{
					
				};
				$scope.save=function()
				{
					depositService.save($scope.model)
					.success(function(data)
							{
								alert("success");
							})	;
				};
		});