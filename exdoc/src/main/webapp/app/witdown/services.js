/**
 * 
 */
app.service('witdownService',['$http',function($http)
                              {
									var service={};
									service.getByKey=function(id)
									{
										
										return $http.get(url+"witdown/getByKey",{params:{key:id}});
									};
									service.save=function(model)
									{
										return $http.post(url+"witdown/save",model);
									};
									service.search=function(model)
									{
										return $http.post(url+"witdown/search",model);
									};
									return service;
                              }]);