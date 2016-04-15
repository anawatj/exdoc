/**
 * 
 */
app.controller('witdownListCtrl', function($scope, $q, $routeParams, $location,
		commonService, witdownService, $uibModal, config) {
	$scope.departments = [];
	$scope.branches = [];
	$scope.positions = [];
	$scope.objectives = [];
	$scope.results = [];
	$scope.totalItems = 0;
	$scope.maxSize = config.maxSize;
	$scope.maxPage = config.maxPage;
	$scope.model = {
		page : 1,
		orderBy : 'id',
		orderType : 'desc'
	};
	
	$scope.init=function()
	{
		
	};
	$scope.initPage=function()
	{
		
	};
	$scope.findWitdownBy=function()
	{
		
	};
	$scope.search=function()
	{
		
	};
	$scope.edit=function(id)
	{
		
	};
});