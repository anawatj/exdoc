/**
 * 
 */
app.controller('rowPopupCtrl',function($scope,$http, $uibModalInstance,$uibModal,config,$pageUtil)
		{
	
				$scope.totalItems =0;
				$scope.results=[];
				$scope.model={page:0};
				$scope.pageSize = config.pageSize;
				$scope.maxSize =config.maxSize;
				
				$scope.save=function()
				{
					var selectedItems=[];
					for(var index=0;index<$scope.results.length;index++)
						{
							var item = $scope.results[index];
							if(item.selected)
							{
								item.selected=false;
								selectedItems.push(item);
							}
						}
					 $uibModalInstance.close(selectedItems);
				};
				$scope.close=function()
				{
					$uibModalInstance.dismiss('cancel');
				};
				$scope.search=function()
				{
					$scope.model.page =$pageUtil.getPage($scope.model.page);
					$http.post(url+"role/search",$scope.model)
					.success(function(data)
							{
								$scope.totalItems  =data.totalRecord;
								$scope.results= data.list;
							});
				};
		});