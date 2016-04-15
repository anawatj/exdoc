/**
 * 
 */
app.controller('borrowEntryCtrl',function($scope,$http,$q,commonService,borrowService,$routeParams,$uibModal,$location)
		{
			$scope.departments=[];
			$scope.branches=[];
			$scope.positions=[];
			$scope.objectives=[];
			$scope.model={id:0,items:[]};
			$scope.id = $routeParams.id;
			
			$scope.init=function()
			{
				if($scope.id==null || $scope.id==undefined)
				{
							$scope.id=0;
				}
			
				var promise = $scope.initPage();
				promise.then(function()
						{
					
						});
			};
			$scope.initPage=function()
			{
				  var deferred = $q.defer();
				  var promise =$q.all
				  ([
				    
				    		commonService.getAllDepartment(),
				    		commonService.getAllBranch(),
				    		commonService.getAllPosition(),
				    		commonService.getAllBorrowObjective(),
				    		borrowService.getByKey($scope.id)
				    ]).then(function(data)
				    		{
				    			
				    				$scope.departments=data[0].data.list;
				    				$scope.branches=data[1].data.list;
				    				$scope.positions=data[2].data.list;
				    				$scope.objectives=data[3].data.list;

				    				$scope.model =data[4].data;
				    				if(!$scope.model)
				    				{
				    					$scope.model={id:0,items:[]};
				    				}
				    				$scope.model.id=$scope.id;
				    				if($scope.model.id>0)
				    				{
				    					$scope.model.borrowBy = commonService.getObject($scope.model.borrowBy);
				    					$scope.model.reviewBy = commonService.getObject($scope.model.reviewBy);
				    					$scope.model.approveBy= commonService.getObject($scope.model.approveBy);
				    					$scope.model.branch = commonService.getObject($scope.model.branch);
				    					$scope.model.department =commonService.getObject($scope.model.department);
				    					$scope.model.position = commonService.getObject($scope.model.position);
				    					$scope.model.borrowDate =commonService.getDate($scope.model.borrowDate);
				    					$scope.model.reviewDate = commonService.getDate($scope.model.reviewDate);
				    					$scope.model.approveDate = commonService.getDate($scope.model.approveDate);
				    					$scope.model.dueDate = commonService.getDate($scope.model.dueDate);
				    					$scope.model.items = commonService.getArray($scope.model.items);
				    					for(var index=0;index<$scope.model.items.length;index++)
				    					{
				    						var item = $scope.model.items[index];
				    						item.document = commonService.getObject(item.document);
				    					}
				    					

				    				}
				    				deferred.resolve(data);
				    		});
				  return promise;
			};
			$scope.findBorrowBy=function()
			{
				var modalInstance = $uibModal.open({
					templateUrl : url+"app/center/views/user.html",
					controller : 'userPopupCtrl',
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
					$scope.model.borrowBy= selectedItem;
				
				}, function() {
					// $log.info('Modal
					// dismissed at: ' + new
					// Date());
				});
			};
			$scope.findReviewBy=function()
			{
				
			};
			$scope.findApproveBy=function()
			{
				
			};
			$scope.findDocument=function(item)
			{
				var modalInstance = $uibModal.open({
					templateUrl : url+"app/center/views/document.html",
					controller : 'documentPopupCtrl',
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
					item.document = selectedItem;
				
				}, function() {
					// $log.info('Modal
					// dismissed at: ' + new
					// Date());
				});
			};
			$scope.addItem = function() {
				
				var item = {};
				if ($scope.id == 0) {
					item.borrowId = undefined;
				} else {
					item.borrowId = $scope.id;
				}
				item.selected = false;
				
				$scope.model.items.push(item);
			};
			$scope.delItem = function() {
				for (var index = 0; index < $scope.model.items.length; index++) {
					var item = $scope.model.items[index];
					if (item.selected) {
						$scope.model.items.splice(index, 1);
						index--;
					}
				}
			};
			$scope.save=function()
			{
				$scope.model.status = "S";
				borrowService.save($scope.model).success(function(data)
						{
							if($scope.id==0)
							{
								$location.path("/borrowEntry").search("id",data.id);
							}else
								{
									window.location.reload();
								}
						});
			};
			$scope.release=function()
			{
				$scope.model.status = "SP";
				borrowService.save($scope.model).success(function(data)
						{
							if($scope.id==0)
							{
								$location.path("/borrowEntry").search("id",data.id);
							}else
								{
									window.location.reload();
								}
						});
			};
			$scope.approve=function()
			{
				$scope.model.status = "AP";
				borrowService.save($scope.model).success(function(data)
						{
							if($scope.id==0)
							{
								$location.path("/borrowEntry").search("id",data.id);
							}else
								{
									window.location.reload();
								}
						});
			};
		});