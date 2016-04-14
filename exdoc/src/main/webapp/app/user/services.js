/**
 * 
 */
app.service('userService',['$http',function($http)
{
	var service ={};
	service.getByKey=function(id)
	{
		return $http.get(url+'user/getByKey',{params:{key:id}});
	};
	service.save=function(model)
	{
		return $http.post(url+"user/save",model);
	};
	service.search=function(model)
	{
		return $http.post(url+"user/search",model);
	};
	return service;
}]);