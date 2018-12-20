
	
  var app = angular.module('way2homeservice.electricalServices', [])
  .directive("datepicker", function () {
	    return {
	        restrict: "A",
	        link: function (scope, el, attr) {
	            el.datepicker({
	                            dateFormat: 'yy-mm-dd'
	                        });
	        }
	    };
	})
   app.controller('userProductController', function($scope, $http,$log, $location) {
	
	   $scope.confirmBookService = function(){
		   $log.debug('electrical services'+$scope.userProductDetails);
		  /* $http.post('/api/userProductServiceDetails',$scope.user)
		   .success(function(data) {
			   $log.debug("asdfsfsdf")
			   if (data.errors) {
			   } else {
				   $scope.data.message = data.message;
			   }
		   })
		   .error(function (err) {
			   alert('some getting error');
		   });*/
		   $http.post("/api/userProductServiceDetails",$scope.userProductDetails)
		   .success(function(data){
			   $log.debug(data);
				
			}).error(function(error){
				 $log.debug(error);
			})
	   }
    $scope.servicesUrl = function(){
    	var selectionProductUrl = $location.absUrl();
    	 var href = $('#userServices').attr('href');
       /*  alert(href);*/
        
         //$scope.confirmBookService(href);
    	
    }
    $scope.baseServicesUrl = function(){
    	var selectionProductUrl = $location.absUrl();
    	 var href = $('').attr('href');
       /*  alert(href);*/
        
         //$scope.confirmBookService(href);
    	
    }
    
});