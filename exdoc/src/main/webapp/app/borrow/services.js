/**
 * 
 */
app.factory('borrowService',['$http',function($http)
                             {
									var service={};
									service.getByKey=function(id)
									{
										return $http.get(url+"borrow/getByKey",{params:{key:id}});
									};
									service.search=function(model)
									{
										return $http.post(url+"borrow/search",model);
									};
									service.save=function(model)
									{
										return $http.post(url+"borrow/save",model);
									}
                             }]);