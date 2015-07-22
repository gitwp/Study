var app = angular.module('imageApp', []);

function imageCtrl($scope, $http) {
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

	$scope.pagingQuery = {};

	$scope.search = function() {
		$scope.ajaxPost("action/queryList", $scope.pagingQuery, function(data) {
			$scope.imagelist = data.respInfo.pagingData;
			$scope.$broadcast("doPaging");
		}, function(data) {
			$scope.showError(data.errorInfo.errorMessage);
		});

	};
	$scope.queryList = function() {
		$scope.search();
	};
	
	$scope.search();
	
	
	$scope.ajaxFileUpload= function(){
		$("#loading").ajaxStart(function() {
			$(this).show();
		}).ajaxComplete(function() {
			$(this).hide();
		});

		$.ajaxFileUpload({
			url : 'action/upload',// servlet请求路径  
			secureuri : false,
			fileElementId : 'fileToUpload',// 上传控件的id  
			dataType : 'json',
			data : {}, // 其它请求参数  
			success : function(data, status) {
				if(data){
					alert('上传成功');
				}
			},
			error : function(data, status, e) {
				alert('上传出错');
			}
		})

		return true;

	}
}