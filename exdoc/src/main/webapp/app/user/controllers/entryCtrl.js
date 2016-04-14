/**
 * 
 */
app.controller('userEntryCtrl',['$scope', '$q', '$location', '$routeParams',
                        		'$uibModal', 'commonService', 'userService', function($scope, $q, $location, $routeParams,
		$uibModal, commonService, userService) {
	$scope.model = {
		id : 0,
		roles:[]
	};
	$scope.id = $routeParams.id;
	$scope.init = function() {
		if ($scope.id == null || $scope.id == undefined) {
			$scope.id = 0;
		}
		userService.getByKey($scope.id)
		.success(function(data)
				{
						$scope.model=data;
						if(!$scope.model)
						{
							$scope.model={};
							$scope.model.id=0;
							$scope.model.roles=[];
						}
				});

	};
	$scope.addRow = function() {
		var modalInstance = $uibModal.open({
			templateUrl : url+"app/center/views/role.html",
			controller : 'rowPopupCtrl',
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

		modalInstance.result.then(function(selectedItems) {
		
			for(var index=0;index<selectedItems.length;index++)
				{
						var item = selectedItems[index];
						var hasRole = $scope.findRole(item);
						if(hasRole==false)
							{
								$scope.model.roles.push(item);
							}
				}
		
		}, function() {
			// $log.info('Modal
			// dismissed at: ' + new
			// Date());
		});
	};
	$scope.findRole=function(item)
	{
		for(var index=0;index<$scope.model.roles.length;index++)
			{
					var role = $scope.model.roles[index];
					if(role.id==item.id)
						{
								return true;
						}
			}
		return false;
	};
	$scope.delRow=function()
	{
		for(var index=0;index<$scope.model.roles.length;index++)
		{
				var role = $scope.model.roles[index];
				if(role.selected)
					{
							$scope.model.roles.splice(index,1);
							index--;
					}
		}
	};
	$scope.save=function()
	{
		userService.save($scope.model)
		.success(function(data)
				{
					$location.path('/userEntry').search('id',data.id);
				})	;
	};
}]);