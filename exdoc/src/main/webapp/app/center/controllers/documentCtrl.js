/**
 * 
 */
app.controller('documentPopupCtrl', function($scope, $http, $q,
		$uibModalInstance, $uibModal, config, $pageUtil) {
	$scope.totalItems = 0;
	$scope.results = [];
	$scope.model = {
		page : 0
	};
	$scope.pageSize = config.pageSize;
	$scope.maxSize = config.maxSize;
	$scope.search=function()
	{
		
	};
	$scope.select=function(item)
	{
		
	};
	$scope.close=function()
	{
		$uibModalInstance.dismiss('cancel');
	};
});
