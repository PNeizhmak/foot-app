angular.module('starter.controllers', [])

.controller('DashCtrl', function($scope, Players) {
  $scope.teams = Players.getTeamsCount();
  $scope.settings = {};
  $scope.settings.balanceWithParent = false;

  $scope.saveTeamsCount = function(count) {
    Players.setTeamsCount(count);
  };

  $scope.balanceWithParentChange = function () {
    Players.setBalanceWithParent($scope.settings.balanceWithParent);
  }
})

.controller('PlayersCtrl', function($scope, $ionicLoading, $state, Players) {
  $scope.$on('$ionicView.enter', function(){
    $ionicLoading.show();
    Players.all().then(function(response){
      $scope.players = response.data;
    }).catch(function(response){
      //request was not successful
      //handle the error
    }).finally(function(){
      $scope.selectedPlayers = 0;
      $ionicLoading.hide();
    });
  });
  $scope.makeTeams = function () {
    Players.setSelectedPlayers($scope.players);
    $state.go('app.teams');
  };
  $scope.updatePlayersCount = function () {
    $scope.selectedPlayers = $scope.players.filter(function (p) {
      return p.checked;
    }).length;
  };
})

.controller('TeamsCtrl', function($scope, $stateParams, $ionicLoading, $ionicModal, Players) {

  $ionicModal.fromTemplateUrl('templates/modal.html', {
    scope: $scope,
    animation: 'slide-in-up',
    focusFirstInput: true
  }).then(function(modal) {
    $scope.modal = modal;
    $scope.modal.show();
  });

  $scope.openModal = function() {
    $scope.modal.show();
  };

  $scope.closeModal = function() {
    $scope.modal.hide();
  };

  $scope.$on('$destroy', function() {
    $scope.modal.remove();
  });

  $scope.$on('modal.hidden', function() {
    // Execute action
  });

  $scope.$on('modal.removed', function() {
    // Execute action
  });

  $scope.alert = function(text) {
    alert(text);
  };

  $scope.save = function (datetime) {
    $ionicLoading.show();
    var game = {datetime: datetime, teams: this.teams}
    Players.save(game).then(function(response){
      // todo goto games
    }).catch(function(response){
      //request was not successful
      //handle the error
    }).finally(function(){
      $ionicLoading.hide();
    });
  };

  $scope.$on('$ionicView.enter', function(){
    $ionicLoading.show();
    Players.shuffle(Players.getSelectedPlayers()).then(function(response){
      $scope.teams =  response.data;
    }).catch(function(response){
      //request was not successful
      //handle the error
    }).finally(function(){
      $ionicLoading.hide();
    });
  });
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
});
