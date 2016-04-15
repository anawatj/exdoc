/**
 * 
 */
app.controller('depositListCtrl',function($scope,$q,$routeParams,$location,commonService,depositService,$uibModal,config)
		{
				$scope.departments=[];
				$scope.branches=[];
				$scope.positions=[];
				$scope.objectives=[];
				$scope.results=[];
				$scope.totalItems=0;
				$scope.maxSize=config.maxSize;
				$scope.maxPage=config.maxPage;
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
								$scope.results =data.list;
								$scope.totalItems=data.totalRecord;
							})	;
				};
				$scope.edit=function(id)
				{
					$location.path("/depositEntry").search("id",id);
					
				};
				$scope.findDepositBy=function()
				{
					var modalInstance = $uibModal.open({
						templateUrl : url+"app/center/views/user.html",
						controller : 'userPopupCtrl',
						size : 'lg',
						backdrop : false,
						animation : true,
						resolve : {
					/*		parameter : function() {
								return model = {
									subject : subject,
									page : 1
								};
							}*/
						}
					});

					modalInstance.result.then(function(selectedItem) {
						$scope.model.depositBy= selectedItem.username;
						//$scope.model.username = selectedItem.username;
					
					}, function() {
						// $log.info('Modal
						// dismissed at: ' + new
						// Date());
					});
				};
				
		});