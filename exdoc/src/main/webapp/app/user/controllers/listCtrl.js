/**
 * 
 */
app.controller('userListCtrl',function($scope,$q,$location,commonService,userService,config,$pageUtil)
		{
				$scope.totalItems=[];
				$scope.results=[];
				$scope.maxSize =config.maxSize;
				$scope.pageSize = config.pageSize;
				$scope.model={page:1};
				$scope.init=function()
				{
					
				};
				$scope.search=function()
				{
					$scope.model.page = $pageUtil.getPage($scope.model.page);
					userService.search($scope.model)
					.success(function(data)
							{
								$scope.totalItems=data.totalRecord;
								$scope.results = data.list;
								
							});
					
				};
				$scope.edit=function(id)
				{
					$location.path("/userEntry").search("id",id);
				};
		});