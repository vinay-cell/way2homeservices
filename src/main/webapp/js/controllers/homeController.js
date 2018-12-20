'use strict';
/*global angular, _*/

angular.module('way2homeservice.homeModule', ['ui.bootstrap'])
  .controller('HomeController', function($scope, $http, $log, $modal, $filter, $location) {
    $scope.headline = "testing";
  });