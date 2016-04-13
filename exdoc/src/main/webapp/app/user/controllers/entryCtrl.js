/**
 * 
 */
app.controller('userEntryCtrl',['$scope', '$q', '$location', '$routeParams',
                        		'$uibModal', 'commonService', 'userService', function($scope, $q, $location, $routeParams,
		$uibModal, commonService, userService) {
	$scope.model = {
		id : 0
	};
	$scope.id = $routeParams.id;
	$scope.init = function() {
		if ($scope.id == null || $scope.id == undefined) {
			$scope.id = 0;
		}

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

		modalInstance.result.then(function(selectedItem) {
			$scope.model.rows = selectedItem.items;
		
		}, function() {
			// $log.info('Modal
			// dismissed at: ' + new
			// Date());
		});
	};
}]);