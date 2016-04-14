/**
 * 
 */
app.controller('rowPopupCtrl',function($scope,$http, $uibModalInstance,$uibModal)
		{
	
				$scope.totalItems =0;
				$scope.results=[];
				$scope.model={page:0};
				$scope.pageSize = 10;
				$scope.maxSize =10;
				
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
					if(!$scope.model.page)
						{
							$scope.model.page=1;
						}
					if($scope.model.page==null || $scope.model.page==undefined)
					{
						$scope.model.page=1;
					}
					if($scope.model.page==0)
						{
						$scope.model.page=1;
						}
					$http.post(url+"role/search",$scope.model)
					.success(function(data)
							{
								$scope.totalItems  =data.totalRecord;
								$scope.results= data.list;
							});
				};
		});