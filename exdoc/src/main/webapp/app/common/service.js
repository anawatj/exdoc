/**
 * 
 */
app.factory("commonService",['$http',function($http)
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
									
                             }]);