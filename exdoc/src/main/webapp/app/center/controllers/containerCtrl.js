/**
 * 
 */
app.controller('containerPopupCtrl',function($scope,$uibModalInstance,
		$uibModal, config, $pageUtil,containerService)
		{
				$scope.results=[];
				$scope.totalItems=0;
				$scope.pageSize = config.pageSize;
				$scope.maxSize = config.maxSize;
				$scope.model={page:1};
				$scope.search=function()
				{
					containerService.search($scope.model)
					.success(function(data)
						{
								$scope.totalItems = data.totalRecord;
								$scope.results= data.list;
								
						});
				};
				$scope.close=function()
				{
					$uibModalInstance.dismiss('cancel');
				};
				$scope.select=function(item)
				{
					 $uibModalInstance.close(item);
				};
		});