angular.module('starter.controllers', [])

.controller('DashCtrl', function($scope) {})

.controller('PlayersCtrl', function($scope, $ionicLoading, $ionicModal, Players) {
  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //
  $ionicModal.fromTemplateUrl('templates/modal.html', {
    scope: $scope,
    animation: 'slide-in-up'
  }).then(function(modal) {
    $scope.modal = modal;
  });
  $scope.openModal = function() {
    $scope.modal.show();
  };
  $scope.closeModal = function() {
    $scope.modal.hide();
  };
  // Cleanup the modal when we're done with it!
  $scope.$on('$destroy', function() {
    $scope.modal.remove();
  });
  $scope.$on('$ionicView.enter', function(){
    $ionicLoading.show();
    Players.all().then(function(response){
      $scope.players = response.data;
    }).catch(function(response){
      //request was not successful
      //handle the error
    }).finally(function(){
      $ionicLoading.hide();
    });
  });

  $scope.shuffle = function() {
    $ionicLoading.show();
    Players.shuffle($scope.players).then(function(response){
      $scope.teams =  response.data;
      $scope.modal.show();
    }).catch(function(response){
      //request was not successful
      //handle the error
    }).finally(function(){
      $ionicLoading.hide();
    });
  };
})

.controller('PlayerDetailCtrl', function($scope, $stateParams, $ionicLoading, Players) {
  $scope.$on('$ionicView.enter', function(){
    $ionicLoading.show();
    Players.get($stateParams.playerId).then(function (response) {
      $scope.player = response.data;
    }).catch(function (response) {
      //request was not successful
      //handle the error
    }).finally(function () {
      $ionicLoading.hide();
    });
  });
})

.controller('AccountCtrl', function($scope) {
  $scope.settings = {
    enableFriends: true
  };
});
