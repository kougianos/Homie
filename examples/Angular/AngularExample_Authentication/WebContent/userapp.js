var app = angular.module('userapp', ['ngResource']);


app.factory('UserEndpoint', ['$resource', '$window',
  function($resource, window){
	return function(customHeaders){
	    return $resource('http://localhost:8080/JSONExample/services/users', {}, {
	          save: { 
		          method: 'POST',
		          params: {},
		          isArray: false,
		          headers: customHeaders || {}
	          },
	          query: {
	        	  method: 'GET',
		          isArray: true
	          }
	      });
	    };
  }]);

app.controller('UserCtrl', ['$scope', '$http', 'UserEndpoint', '$window', function($scope, $http, UserEndpoint, window) {
	$scope.users = UserEndpoint().query();
	$scope.newuser = new Object();
	$scope.logininfo = new Object();
	
	$scope.login = function() {
		$http
        .post('http://localhost:8080/JSONExample/services/users/login', $scope.logininfo)
        .success(function(response){
        	window.sessionStorage.token = response;
        });
	};
	$scope.insertUser = function() {
        var saveresult = UserEndpoint({Authorization: 'Bearer ' + window.sessionStorage.token}).save($scope.newuser);
		saveresult.$promise.then(function () {
        $scope.users = UserEndpoint().query();
		});
    };
	
}]);
	
	



	


