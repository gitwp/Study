var app = angular.module('app', []);

function testCtrl($scope, $http) {
	$scope.formField={};
	$scope.ajaxPost = function(url, payload, callback, errCallback, beforeSend) {
		if (beforeSend && typeof (beforeSend) == "function") {
			beforeSend();
		}
		$http.post(url, payload).success(function(data) {
			if (callback && typeof (callback) == "function") {
				callback(data);
			}
		});
	};

	$scope.test = function() {
		var params = {};
		params.username = $scope.formField.username;
		params.password = $scope.formField.password;
		params.status = $scope.formField.status;
		params.phone = $scope.formField.phone;
		$scope.ajaxPost("action/test/submit", params, function(data) {
//			alert("ok：" + data.respInfo.nowDate);
			if(data.respInfo.succ){
				alert(data.respInfo.succ);
			}
			if(data.respInfo.error){
				alert(data.respInfo.error);
			}
		});
	}
}