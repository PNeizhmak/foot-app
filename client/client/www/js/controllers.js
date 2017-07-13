angular.module('starter.controllers', [])

  .controller('DashCtrl', function ($scope, Players) {
    $scope.teams = Players.getTeamsCount();
    $scope.settings = {};
    $scope.settings.balanceWithParent = false;

    $scope.saveTeamsCount = function (count) {
      Players.setTeamsCount(count);
    };

    $scope.balanceWithParentChange = function () {
      Players.setBalanceWithParent($scope.settings.balanceWithParent);
    }
  })

  .controller('PlayersCtrl', function ($scope, $ionicLoading, $state, Players) {
    $scope.$on('$ionicView.enter', function () {
      $ionicLoading.show();
      Players.all().then(function (response) {
        $scope.players = response.data;
      }).catch(function (response) {
        //request was not successful
        //handle the error
      }).finally(function () {
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

  .controller('TeamsCtrl', function ($scope, $stateParams, $ionicLoading, $ionicModal, $state, $ionicHistory, Players, Game) {

    $ionicModal.fromTemplateUrl('templates/teams-modal.html', {
      scope: $scope,
      animation: 'slide-in-up',
      focusFirstInput: true
    }).then(function (modal) {
      $scope.modal = modal;
      $scope.modal.show();
    });

    $scope.openModal = function () {
      $scope.modal.show();
    };

    $scope.closeModal = function () {
      $scope.modal.hide();
    };

    $scope.$on('$destroy', function () {
      $scope.modal.remove();
    });

    $scope.$on('modal.hidden', function () {
      // Execute action
    });

    $scope.$on('modal.removed', function () {
      // Execute action
    });

    $scope.alert = function (text) {
      alert(text);
    };

    $scope.save = function (datetime) {
      $ionicLoading.show();
      var game = {datetime: datetime, teams: this.teams};
      Game.save(game).then(function (response) {
      }).catch(function (response) {
        //request was not successful
        //handle the error
      }).finally(function () {
        $ionicLoading.hide();
        $scope.closeModal();
        $ionicHistory.nextViewOptions({
          disableBack: true
        });
        $state.go('app.games');
      });
    };

    $scope.$on('$ionicView.enter', function () {
      $ionicLoading.show();
      Players.shuffle(Players.getSelectedPlayers()).then(function (response) {
        $scope.teams = response.data;
      }).catch(function (response) {
        //request was not successful
        //handle the error
      }).finally(function () {
        $ionicLoading.hide();
      });
    });
  })

  .controller('GamesCtrl', function ($scope, $stateParams, $ionicLoading, Game) {
    $scope.$on('$ionicView.enter', function () {
      $ionicLoading.show();
      Game.all().then(function (response) {
        $scope.games = response.data;
        angular.forEach($scope.games, function (value, index) {

          $scope.games[index].teams = [];

          Game.findTeamsByGameId(value.id).then(function (res) {
            $scope.games[index].teams.push(res.data);
          });

          console.log();
        })
      }).catch(function (response) {
        //request was not successful
        //handle the error
      }).finally(function () {
        $ionicLoading.hide();
      });
    });

    $scope.toggleGame = function (game) {
      game.show = !game.show;
    };

    $scope.isGameShown = function (game) {
      return game.show;
    };
  })

  .controller('PlayerDetailCtrl', function ($scope, $stateParams, $ionicLoading, Players) {
    $scope.$on('$ionicView.enter', function () {
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
