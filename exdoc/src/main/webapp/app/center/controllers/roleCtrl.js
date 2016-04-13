/**
 * 
 */
app.controller('rowPopupCtrl',function($scope,$http, $uibModalInstance,$uibModal)
		{
				
				$scope.save=function()
				{
					
				};
				$scope.close=function()
				{
					$uibModalInstance.dismiss('cancel');
				};
		});