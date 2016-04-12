/**
 * 
 */
app.service("commonService",['$http',function($http)
                             {
									var service={};
									service.getAllDepartment=function()
									{
										return $http.get(url+"master/department/getAll");
									};
									service.getAllBorrowObjective=function()
									{
										return $http.get(url+"master/borrow/objective/getAll");
									};
									service.getAllBranch=function()
									{
										return $http.get(url+"master/branch/getAll");
									};
									service.getAllPosition=function()
									{
										return $http.get(url+"master/position/getAll");
									};
									service.getAllDocumentGroup=function()
									{
										return $http.get(url+"master/documentGroup/getAll");
									};
									service.getAllDocumentMode=function()
									{
										return $http.get(url+"master/documentMode/getAll");
									};
									service.getAllDocumentType=function()
									{
										return $http.get(url+"master/documentType/getAll");
									};
									service.getAllDepositObjective=function()
									{
										return $http.get(url+"master/deposit/objective/getAll");
									};
									service.getObject=function(obj)
									{
										if(obj==null || obj==undefined)
										{
											obj = {};
											
										}
										if(obj.id==undefined)
										{
												obj.id=0;
										}
										return obj;
									};
									service.getDate=function(obj)
									{
										return new Date(obj);
									}
									service.getArray=function(items)
									{
										if(items==null || items==undefined)
											{
												items = [];
											}
										return items;
									}
									return service;
									
                             }]);