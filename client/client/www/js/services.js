var module = angular.module('starter.services', []);

module.factory('Players', function ($http) {

  var dataSource = 'http://localhost:8080';
  var selectedPlayers = [];
  var teamsCount = 2;
  var balanceWithParent = false;

  return {
    all: function () {
      return $http.get(dataSource + "/players/all");
    },
    shuffle: function (players) {
      var ids = players.filter(function (p) {
        return p.checked;
      }).map(function (p) {
        return p.id;
      }).join(',');
      return $http.get(dataSource + "/team-balancer/makeTeams", {
        params: {
          playerIds: ids,
          teamsCount: teamsCount,
          balanceWithParent: balanceWithParent,
          createPng: true
        }
      });
    },
    get: function (playerId) {
      return $http.get(dataSource + "/players/get-by-id", {params: {id: playerId}});
    },
    setSelectedPlayers: function (players) {
      selectedPlayers = players;
    },
    getSelectedPlayers: function () {
      return selectedPlayers;
    },
    setTeamsCount: function (count) {
      teamsCount = count;
    },
    getTeamsCount: function () {
      return teamsCount;
    },
    setBalanceWithParent: function (param) {
      balanceWithParent = param;
    },
    getBalanceWithParent: function () {
      return balanceWithParent;
    }
  };
});

module.factory('Game', function ($http) {

  var dataSource = 'http://localhost:8080';

  return {
    all: function () {
      return $http.get(dataSource + "/game/all-games");
    },
    save: function (game) {
      var data = {
        date: game.datetime,
        teams: game.teams
      };
      return $http.post(dataSource + "/game/save", data);
    },
    findTeamsByGameId: function (gameId) {
      return $http.get(dataSource + "/game/find-teams-by-game-id", {params: {gameId: gameId}});
    }
  };
});
