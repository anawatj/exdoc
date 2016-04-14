/**
 * 
 */
app.controller('userPopupCtrl', function($scope, $http, $uibModalInstance,
		$uibModal, config, $pageUtil,userService) {
	$scope.totalItems = 0;
	$scope.results = [];
	$scope.model = {
		page : 0
	};
	$scope.pageSize = config.pageSize;
	$scope.maxSize = config.maxSize;
	$scope.close = function() {
		$uibModalInstance.dismiss('cancel');
	};
	$scope.search = function() {
		$scope.model.page =$pageUtil.getPage($scope.model.page);
			userService.search($scope.model)
			.success(function(data)
					{
							$scope.results=data.list;
							$scope.totalItems = data.totalRecord;
					});
	};
	$scope.select=function(item)
	{
		 $uibModalInstance.close(item);
	};
});