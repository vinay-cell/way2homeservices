
	
  var app = angular.module('way2homeservice', []);
   app.controller('myCtrl.services', function($scope, $log, $location) {
	$scope.user = {}; 
	$scope.user.url;
	 $scope.confirmBookServiceUser = function(){
		 $scope.user.url = $location.$$absUrl;
	      //alert('hi');
		 $http.get('/userRelatedServices')
         .success(function (user) {
         
         })
         .error(function (err, status) {
          
         });
		 //$scope.confirmBookService($scope.user.url);
	    }
    $scope.confirmBookService = function(currentUrl){
    	$log.debug('electrical services');
    	/*$scope.user.pincode,
    	$scope.user.emailId*/
    	$http({
            method  : 'POST',
            url     : 'userCarpenterServiceDetail',
            data    : $scope.user, //forms user object
            data    : currentUrl
          
            
           })
           .success(function(data) {
               if (data.errors) {
                 // Showing errors.
                
               } else {
                 $scope.data.message = data.message;
               }
             })
             .error(function (err) {
                 //alert('some getting error');
               });
    }
    
});