var app = angular.module('way2homeservice', []);
app.controller('myCtrl', function($scope, $log) {
    $scope.ContactUs ="Contact Us";
    $scope.user = {}; 
    $scope.submitFormBtn = function(){
    	$log.debug('ContactUs');
    	/* $http.get("conctFormSubmition")
        .then(function(response) {
            $scope.conctFormSubmition = response.data;
        }).error(function (errorstatus) {
        	alert(errorstatus);
			
		}); */
		  
		/*  $scope.user.name, //forms user object
         $scope.user.lastName,
         $scope.user.mobileNo,
         $scope.user.email,
         $scope.user.textMsg */
    	$http({
            method  : 'POST',
            url     : 'contactWayToHomeServices',
            data    : $scope.user, //forms user object
          
            
           })
           .success(function(data) {
               if (data.errors) {
                 // Showing errors.
                
               } else {
                 $scope.data.message = data.message;
               }
             });
    }
/*     $scope.servicesUrl = function(){
             alert("As you can see, the link no longer took you to jquery.com");
             var href = $('.servicesUrl').attr('href');
             alert(href);
             event.preventDefault();
     
    	
    }*/
    
});