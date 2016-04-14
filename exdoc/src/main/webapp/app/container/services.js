/**
 * 
 */
app.service('containerService',['$http',function($http)
                                {
										var service = {};
										service.getByKey=function(id)
										{
											return $http.get(url+"container/getByKey",{params:{key:id}});
										};
										service.search=function(model)
										{
											return $http.post(url+"container/search",model);
										};
										service.save=function(model)
										{
											return $http.post(url+"container/save",model);
										};
										return service;
                                }]);