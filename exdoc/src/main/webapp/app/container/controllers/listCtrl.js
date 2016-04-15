/**
 * 
 */
app.controller('containerListCtrl',function($scope,$q,$routeParams,$location,containerService,commonService,config,$pageUtil,$uibModal)
		{
				$scope.model = {page:1};
				$scope.results=[];
				$scope.departments=[];
				$scope.branches=[];
				$scope.containerTypes=[];
				$scope.totalItems=0;
				$scope.maxSize=config.maxSize;
				$scope.pageSize=config.pageSize;
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
							 	commonService.getAllContainerType()
							 ]
					).then(function(data)
							{
									$scope.departments=data[0].data.list;
									$scope.branches=data[1].data.list;
									$scope.containerTypes=data[2].data.list;
									deferred.resolve(data);
							})	;
					return promise;
				};
				$scope.search=function()
				{
					$scope.model.page= $pageUtil.getPage($scope.model.page);
					containerService.search($scope.model)
					.success(function(data)
							{
								$scope.totalItems=data.totalRecord;
								$scope.results =data.list;
							});
				};
				$scope.edit=function(id)
				{
					$location.path("/containerEntry").search("id",id);
				};
				$scope.findContainerBy=function()
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
						$scope.model.containerBy = selectedItem.username;
					
					}, function() {
						// $log.info('Modal
						// dismissed at: ' + new
						// Date());
					});
				}
				
		});