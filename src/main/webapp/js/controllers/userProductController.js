var app = angular.module('way2homeservice.userProductModule', ['ui.bootstrap'])
/*.run(['$anchorScroll', function($anchorScroll) {
	  $anchorScroll.yOffset = 50;   // always scroll by 50 extra pixels
	}])*/
app.controller('userProductController', function($scope, $http,$log, $location) {
	/*$scope.myInterval = 3000;
	$scope.noWrapSlides = false;
	$scope.active = 0;
	var slides = $scope.slides = [];
	var currIndex =0;
	
	$scope.moveTo = function(dest){
		console.log(dest);
		$anchorScroll(dest);
		
	}
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

	for (var i = 0; i < 4; i++) {
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
	}*/
}).controller('userProductControllers', function($scope, $http,$log, $location) {
	
	 $scope.userProductDetails = {};
	   $scope.confirmBookService = function(){
		   $log.debug('electrical services'+$scope.userProductDetails);
		   if ($scope.userProductDetails.chekedok != true) {
             alert("Please select checkbox for apply terms and condition.");
         }
		   $http.post('/api/userProductServiceDetails',$scope.userProductDetails)
		   .success(function(data){
			   $log.debug(data);
			   $scope.responseMsg=data;
				
			}).error(function(error){
				 $log.debug(error);
			})
	   }
	   $scope.submitFormBtn = function(){
		   $http.post('/api/userProductServiceDetails',$scope.userProductDetails)
		   .success(function(data){
			   $log.debug(data);
				
			}).error(function(error){
				 $log.debug(error);
			})
	        }
      

});