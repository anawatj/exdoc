/**
 * 
 */
app.controller('documentPopupCtrl', function($scope, $http, $q,
		$uibModalInstance, $uibModal, config, $pageUtil,commonService) {
	$scope.totalItems = 0;
	$scope.results = [];
	$scope.model = {
		page : 0
	};
	$scope.pageSize = config.pageSize;
	$scope.maxSize = config.maxSize;
	$scope.documentGroups=[];
	$scope.documentModes=[];
	$scope.documentTypes=[];
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
		var promise = $q.all
		(
				[	
				 		commonService.getAllDocumentGroup(),
				 		commonService.getAllDocumentMode(),
				 		commonService.getAllDocumentType()
				 ]
		).then(function(data)
				{
						$scope.documentGroups = data[0].data.list;
						$scope.documentModes= data[1].data.list;
						$scope.documentTypes = data[2].data.list;
						deferred.resolve(data);
				});
		return promise;
		
	};
	$scope.findContainer=function()
	{
		var modalInstance = $uibModal.open({
			templateUrl : url+"app/center/views/container.html",
			controller : 'containerPopupCtrl',
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
		$scope.model.container = selectedItem.containerCode;
		
		}, function() {
			// $log.info('Modal
			// dismissed at: ' + new
			// Date());
		});
	};
	$scope.search=function()
	{
		$scope.model.page= $pageUtil.getPage($scope.model.page);
		$http.post(url+"document/search",$scope.model)
		.success(function(data)
				{	
						$scope.totalItems= data.totalRecord;
						$scope.results =data.list;
			
				});
	};
	$scope.select=function(item)
	{
		$uibModalInstance.close(item);
	};
	$scope.close=function()
	{
		$uibModalInstance.dismiss('cancel');
	};
});
