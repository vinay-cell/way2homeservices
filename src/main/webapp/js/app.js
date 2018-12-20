'use strict';

/* App Module */

var way2homeservice = angular.module('way2homeservice', [
  'ngRoute',
  'ui.bootstrap',
  'hSweetAlert'
  
 
  
  /*'way2homeservice.userProductModule'*/
  /* 'ngTouch',
  'ngTable',
  'dndLists',
  'ui.bootstrap',*/
  /*'way2homeservice.homeModule',
  'way2homeservice.electricalServices',
  'way2homeservice.corpenterServices',
  'way2homeservice.interiorServices',
  'way2homeservice.paintingServices',
  'way2homeservice.printingServices'*/

])
.service('LoadingInterceptor',LoadingInterceptor)
.config(config);;
config.$inject = ['$httpProvider'];


function config($httpProvider) {
            $httpProvider.interceptors.push('LoadingInterceptor');
};

way2homeservice.config(['$routeProvider',
  function ($routeProvider) {
    $routeProvider.
        when('/', {
          templateUrl: 'partials/index.html'
        }).
        when('/electrical', {
            templateUrl: 'partials/electrical-services.tpl.html',
            controller: 'userProductController'
          }).
          when('/plumber',{
          	templateUrl: 'partials/plumber-services.tpl.html',
          	controller: 'userProductController'
          }).
          when('/carpenter',{
          	templateUrl: 'partials/carpenter-services.tpl.html',
          	controller: 'userProductController'
          }).
          when('/painting',{
          	templateUrl: 'partials/painting-services.tpl.html',
          	controller : 'userProductController'
          	
          }).
          when('/interior',{
        	templateUrl: 'partials/interior-services.tpl.html', 
          	controller:'userProductController'
          }).
          when('/bookUserTmpl/:type',{
          	templateUrl: 'partials/booking-page.tpl.html', 
            	
            }).
            when('/terms',{
                templateUrl: 'partials/terms-and-conditions.html'
              })
        .otherwise({
          redirectTo: '/'
        });
  }]).run(['$anchorScroll', function($anchorScroll) {
	  $anchorScroll.yOffset = 50;   // always scroll by 50 extra pixels
	}])
way2homeservice.controller('scrollerController',function($scope, $http,$log, $location,$window,$anchorScroll,$rootScope,$routeParams,sweet) {

	    
	 $scope.customerBookingDetails = {};
	  $scope.phoneNumbr = /^\+?\d{2}[- ]?\d{3}[- ]?\d{5}$/;
	  $scope.word = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
	   $scope.model={};
	
	 $scope.confirmBookService = function(check){
		 $scope.customerBookingDetails.serviceName = $routeParams.type;
		 $scope.customerBookingDetails.requestType = 'BOOKING'
		   if(check){
			
		   $log.debug('electrical services'+$scope.customerBookingDetails);
		   $http.post('/api/customerBookingDetails',$scope.customerBookingDetails)
		   .success(function(data){ 
			   
			   sweet.show({
				   title: data.status,
				   text: data.message,
				   type: "success",
				   confirmButtonColor: "#DD6B55",
				   confirmButtonText: "Ok",
				   closeOnConfirm: false}, 
				function(){ 
					   $scope.customerBookingDetails= {};
					   window.location.reload();
				});
			   
			   
			 
			   $log.debug(data);
			   $scope.responseMsg=data;
			
			}).error(function(error){
				 $log.debug(error);
			})
		   }
	   }
	
		 $scope.customerBookingDetails = {};
		  $scope.phoneNumbr = /^\+?\d{2}[- ]?\d{3}[- ]?\d{5}$/;
		  $scope.word = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
		   $scope.confirmBookServiceForm = function(check){
			   //$scope.errorMesssage = "";
			   $scope.customerBookingDetails.requestType = 'CONTACT'
			   if(check){
			   $log.debug('contact submition'+$scope.customerBookingDetails);
			   $http.post('/api/customerBookingDetails',$scope.customerBookingDetails)
			   .success(function(data){
				   //sweet.show( data.status,data.message , "success");
				  
				   sweet.show({
					   title: data.status,
					   text: data.message,
					   type: "success",
					   confirmButtonColor: "#DD6B55",
					   confirmButtonText: "Ok",
					   closeOnConfirm: false}, 
					function(){ 
						   $scope.customerBookingDetails= {};
						   window.location.reload();
					});
				   
				   
				   $log.debug(data);
				}).error(function(error){
					 $log.debug(error);
				})
		      }else{
			   /*$scope.errorMesssage = "please fill the all the blanks";*/
		   }
			   
		   }
		   

	$scope.moveTo = function(dest){
		console.log(dest);
		$anchorScroll(dest);
		var listItems = document.querySelectorAll('.menuList li');
		listItems.className ="menulist";
		
	}
	$scope.myInterval = 3000;
	$scope.noWrapSlides = false;
	$scope.active = 0;
	var slides = $scope.slides = [];
	var currIndex =0;
/*	
	$scope.moveTo = function(dest){
		console.log(dest);
		$anchorScroll(dest);
		
	}*/
	$scope.desc=[
	             {
	            	 name:"Interior Design",
	            	 desc:"Design for difference",
	            	 clickEvent:'interior'
	             },
	             {
	            	 name:"Carpenter",
	            	 desc:"For All your Carpentry and Joinary works",
	            	 clickEvent:'carpenter'
	             },
	             {
	            	 name:"Electrician",
	            	 desc:"Electrical Services for the Home and Business",
	            	 clickEvent:'electrical'
	             },
	             {
	            	 name:"Painting",
	            	 desc:"Residential and Commercial Painters",
	            	 clickEvent:'painting'
	             },
	             {
	            	 name:"Plumber",
	            	 desc:"Residential and Commercial Plumbing",
	            	 clickEvent:'plumber'
	             }
	             ]
	$scope.addSlide = function() {

		slides.push({
			image: 'images/slider0'+currIndex+'.jpg',
			name:$scope.desc[currIndex],
			id: currIndex++
		});
		console.log(slides);
	};

	$scope.randomize = function() {
		var indexes = generateIndexesArray();
		assignNewIndexesToSlides(indexes);
	};

	for (var i = 0; i < 5; i++) {
		$scope.addSlide();
	}

	// Randomize logic below

	function assignNewIndexesToSlides(indexes) {
		for (var i = 0, l = slides.length; i < l; i++) {
			slides[i].id = indexes.pop();
		}
	}

	function generateIndexesArray() {
		var indexes = [];
		for (var i = 0; i < currIndex; ++i) {
			indexes[i] = i;
		}
		return shuffle(indexes);
	}

	// http://stackoverflow.com/questions/962802#962890
	function shuffle(array) {
		var tmp, current, top = array.length;
		if (top) {
			while (--top) {
				current = Math.floor(Math.random() * (top + 1));
				tmp = array[current];
				array[current] = array[top];
				array[top] = tmp;
			}
		}
		return array;
	}

});


// this for loader 
LoadingInterceptor.$inject = ['$q', '$rootScope', '$log'];
/* @ngInject */
function LoadingInterceptor($q, $rootScope, $log) {
     var rejectedUrl = [
                
            ];

    var xhrCreations = 0;
    var xhrResolutions = 0;

    function isLoading() {
        return xhrResolutions < xhrCreations;
    }

    function updateStatus() {
        $rootScope.xhrLoading = isLoading();
    }

    return {
        request: function (config) {
            if (rejectedUrl.indexOf(config.url) == -1) {
                xhrCreations++;
                updateStatus();
            }
            return config;
        },
        requestError: function (rejection) {
            if (rejectedUrl.indexOf(rejection.config.url) == -1) {
                xhrResolutions++;
                updateStatus();
                $log.error('Request error:', rejection);
            }
            return $q.reject(rejection);
        },
        response: function (response) {
            if (rejectedUrl.indexOf(response.config.url) == -1) {
                xhrResolutions++;
                console.log('asdf')
                updateStatus();
            }
            return response;
        },
        responseError: function (rejection) {
            if (rejectedUrl.indexOf(rejection.config.url) == -1) {
                xhrResolutions++;
                updateStatus();
                $log.error('Response error:', rejection);
            }
            return $q.reject(rejection);
        }
    };
}

 

/*
angular.module('directive.loading', ['$watch'])

.directive('loading',   ['$http' ,function ($http)
{
    return {
        restrict: 'A',
        link: function (scope, elm, attrs)
        {
            scope.isLoading = function () {
                return $http.pendingRequests.length > 0;
            };

            scope.$watch(scope.isLoading, function (v)
            {
                if(v){
                    elm.show();
                }else{
                    elm.hide();
                }
            });
        }
    };

}]);*/