var app = angular.module('app',[]);

function testCtrl($scope, $http) {
	$scope.ajaxPost = function(url, payload, callback, errCallback, beforeSend) {
		if (beforeSend && typeof (beforeSend) == "function") {
			beforeSend();
		}
		//从cookie中取token值
		$http.defaults.headers.post['X-XSRF-TOKEN']=$.cookie('XSRF-TOKEN');
		//从隐藏域中取cookie值
		$scope.token = $("#token").val();
		
		$http.post(url, payload).success(function(data) {
			if (callback && typeof (callback) == "function") {
				callback(data);
			}
		});
	};
	
	$scope.test = function(){
		$scope.ajaxPost("action/test",{},function(data){
		alert("ok："+data.respInfo.nowDate);
	});
	}
}