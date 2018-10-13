var app = angular.module('userapp', ['ngResource']);

app.factory('UserEndpoint', ['$resource',
  function($resource){
    return $resource('http://localhost:8080/JSONExample/services/users');
  }]);

app.controller('UserCtrl', ['$scope', 'UserEndpoint', function($scope, UserEndpoint) {
	$scope.newuser = new Object();
	$scope.insertUser = function() {
        var saveresult = UserEndpoint.save($scope.newuser);
		saveresult.$promise.then(function () {
        $scope.users = UserEndpoint.query();
		});
    }
	
}]);
	
	



	


