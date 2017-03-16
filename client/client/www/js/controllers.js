angular.module('starter.controllers', [])

.controller('DashCtrl', function($scope) {})

.controller('PlayersCtrl', function($scope, $ionicLoading, Players) {
  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //
  var _this = this;
  $scope.$on('$ionicView.enter', function(){
    $ionicLoading.show();
    Players.all().then(function(response){
      _this.players = response.data;
    }).catch(function(response){
      //request was not successful
      //handle the error
      $ionicLoading.hide();
    }).finally(function(){
      $ionicLoading.hide();
    });
  });

  $scope.remove = function(player) {
    Players.remove(player);
  };
})

.controller('ChatDetailCtrl', function($scope, $stateParams, $ionicLoading, Players) {
  $scope.player = Players.get($stateParams.playerId);
})

.controller('AccountCtrl', function($scope) {
  $scope.settings = {
    enableFriends: true
  };
});
