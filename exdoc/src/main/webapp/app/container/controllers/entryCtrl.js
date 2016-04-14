/**
 * 
 */
app.controller('containerEntryCtrl',function($scope,$q,$routeParams,$location,$uibModal,commonService,containerService)
		{
				$scope.model={id:0,level:1,items:[]};
				$scope.id= $routeParams.id;
				$scope.departments=[];
				$scope.branches=[];
				$scope.containerTypes=[];
				$scope.init=function()
				{
					if($scope.id==null || $scope.id==undefined)
					{
						$scope.id=0;
					}
					var promise= $scope.initPage();
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
							 		commonService.getAllDepartment(),
							 		commonService.getAllBranch(),
							 		commonService.getAllContainerType(),
							 		containerService.getByKey($scope.id)
							 ]
					).then(function(data)
					{
						$scope.departments=data[0].data.list;
						$scope.branches= data[1].data.list;
						$scope.containerTypes =data[2].data.list;
						$scope.model = data[3].data;
						if(!$scope.model)
						{
							$scope.model={id:0,level:1,items:[]};
						}
						$scope.model.id= $scope.id;
						if($scope.model.id>0)
						{
							$scope.model.containerBy= commonService.getObject($scope.model.containerBy);
							$scope.model.branch= commonService.getObject($scope.model.branch);
							$scope.model.department=commonService.getObject($scope.model.department);
							$scope.model.containerType= commonService.getObject($scope.model.containerType);
							$scope.model.items = commonService.getArray($scope.model.items);
							$scope.model.containerDate =commonService.getDate($scope.model.containerDate);
							for(var index=0;index<$scope.model.items.length;index++)
							{
								var item  =$scope.model.items[index];
								item.containerBy= commonService.getObject(item.containerBy);
								item.branch= commonService.getObject(item.branch);
								item.department=commonService.getObject(item.department);
								item.containerType= commonService.getObject(item.containerType);
								item.items = commonService.getArray(item.items);
								item.containerDate =commonService.getDate(item.containerDate);
							}
						}
						deferred.resolve(data);
					});
					return promise;
				};
				$scope.addItem=function()
				{
					var item = {};
					item.id=0;
					if($scope.model.id==0)
					{
						item.parentId = undefined;
					}else
					{
						item.parentId=$scope.model.id;
					}
					item.level = $scope.model.level+1;
					item.selected=false;
					$scope.model.items.push(item);
				};
				$scope.delItem=function()
				{
					for(var index=0;index<$scope.model.items.length;index++)
					{
						var item  =$scope.model.items[index];
						if(item.selected)
						{
							$scope.model.items.splice(index,1);
							index--;
						}
					}
				};
				$scope.findContainerBy=function()
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
						$scope.model.containerBy= selectedItem;
					
					}, function() {
						// $log.info('Modal
						// dismissed at: ' + new
						// Date());
					});
				};
				$scope.findSubContainerBy=function(item)
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
						item.containerBy= selectedItem;
					
					}, function() {
						// $log.info('Modal
						// dismissed at: ' + new
						// Date());
					});
				};
				$scope.save=function()
				{
					containerService.save($scope.model)
					.success(function(data)
							{
									if($scope.id==0)
									{
										
										$location.path("/containerEntry").search("id",data.id);
									}else
									{
										window.location.reload();
									}
									
							})	;
				};
				
		});