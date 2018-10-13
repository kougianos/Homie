var app = angular.module('studentDirective', []);

var ctrl = app.controller('Controller', ['$scope', 		function($scope) {    
	$scope.ihamod = { name: 'ihamod', address: 'A17' };    
	$scope.teststudent = { name: 'Test', address: 'DIT' };}]);

var studentDirective = ctrl.directive('myStudent', function() {    
	return {      
		restrict: 'E',      
		scope: {studentInfo: '=info'},      
		templateUrl: 'my-student-tpl.html'
	} 
});
