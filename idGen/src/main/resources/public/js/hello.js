angular.module('hello', ["ng-fusioncharts"]).controller('home', function($scope, $http) {
	$scope.loadResult = function(){
		$('.btn-primary').blur();
		$scope.labels = [];
		$scope.uuids = [];
		$scope.samls = [];
		$scope.basics = [];
		$scope.acoms = [];
		$scope.loading = true;
		$http.get('/resource').success(function(data) {
			$scope.greeting = data;
			angular.forEach($scope.greeting.labels, function(value,key) {
				$scope.labels.push({"label":value});
			});
			angular.forEach($scope.greeting.uuids, function(value,key) {
				$scope.uuids.push({"value":value});
			});
			angular.forEach($scope.greeting.samls, function(value,key) {
				$scope.samls.push({"value":value});
			});
			angular.forEach($scope.greeting.acoms, function(value,key) {
				$scope.acoms.push({"value":value});
			});
			angular.forEach($scope.greeting.basics, function(value,key) {
				$scope.basics.push({"value":value});
			});
			$scope.categories = [
			    {
			        "category": $scope.labels
			    }
			];

			$scope.dataset = [
			    {
			        "seriesname": "UUID",
			        "data": $scope.uuids
			    },
			    {
			        "seriesname": "Samls",
			        "data": $scope.samls
				},
				{
					"seriesname": "Acomms",
					"data": $scope.acoms
				},
				{
					"seriesname": "Basic",
					"data": $scope.basics
				}
			];

		})
		.finally(function () {
			// Hide loading spinner whether our call succeeded or failed.
			$scope.loading = false;
		});
	};
	
	$scope.loadResult();
	
	$scope.cclasses=[
		'text-info',
		'text-success',
		'text-warning',
		'text-danger'
	];
	
	$scope.attrs = {
			"caption": "Comparing Java ID Generators for latest 10 generations",
			"numberprefix": "MS",
			"plotgradientcolor": "",
			"bgcolor": "FFFFFF",
			"showalternatehgridcolor": "0",
			"divlinecolor": "CCCCCC",
			"showvalues": "0",
			"showcanvasborder": "0",
			"canvasborderalpha": "0",
			"canvasbordercolor": "CCCCCC",
			"canvasborderthickness": "1",
			"yaxismaxvalue": "4000",
			"captionpadding": "30",
			"linethickness": "3",
			"yaxisvaluespadding": "15",
			"legendshadow": "0",
			"legendborderalpha": "0",
			"palettecolors": "#f8bd19,#008ee4,#33bdda,#e44a00,#6baa01,#583e78",
			"showborder": "0"
	};
});