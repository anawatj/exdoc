/**
 * 
 */
app.service('depositService',['$http',function($http)
                              {
									
	
										var service={};
										service.getByKey=function(id)
										{
											return $http.get(url+"deposit/getByKey",{params:{key:id}});
										};
										service.search=function(model)
										{
											return $http.post(url+"deposit/search",model);
										};
										service.save=function(model)
										{
											return $http.post(url+"deposit/save",model);
										};
										return service;
										
                              }]);	