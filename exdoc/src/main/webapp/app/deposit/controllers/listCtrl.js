/**
 * 
 */
app.controller('depositListCtrl',function($scope,$q,$routeParams,$location,commonService,depositService)
		{
				$scope.departments=[];
				$scope.branches=[];
				$scope.positions=[];
				$scope.objectives=[];
				$scope.list=[];
				$scope.totalRecord=0;
				$scope.totalPage=0;
				$scope.model={page:1,orderBy:'id',orderType:'desc'};
				$scope.init=function()
				{
					var promise = $scope.initPage();
					promise.then(function()
							{
						
							});
				};
				$scope.initPage=function()
				{
					var deferred= $q.defer();
					var promise = $q.all
					(
								[
								 	commonService.getAllDepartment(),
								 	commonService.getAllBranch(),
								 	commonService.getAllPosition(),
								 	commonService.getAllDepositObjective()
								 ]
					).then(function(data)
							{
									$scope.departments=data[0].data.list;
									$scope.branches=data[1].data.list;
									$scope.positions=data[2].data.list;
									$scope.objectives=data[3].data.list;
									deferred.resolve(data);
							});
					return promise;
				};
				$scope.search=function()
				{
					depositService.search($scope.model)
					.success(function(data)
							{
								$scope.list =data.list;
								$scope.totalRecord=data.totalRecord;
								$scope.totalPage =data.totalPage;
							})	;
				}
		});