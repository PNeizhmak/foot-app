angular.module('starter.services', [])

.factory('Players', function($http) {

  var dataSource = 'http://localhost:8080';
  var selectedPlayers = [];
  var teamsCount = 2;
  var balanceWithParent = false;

  return {
    all: function() {
      return $http.get(dataSource + "/players/all");
    },
    shuffle: function(players) {
      var ids = players.filter(function (p) {
        return p.checked;
      }).map(function (p) {
        return p.id;
      }).join(',');
      return $http.get(dataSource + "/team-balancer/makeTeams", {params: {playerIds: ids, teamsCount: teamsCount, balanceWithParent: balanceWithParent, createPng: true}});
    },
    save: function (game) {
      return $http.get(dataSource + "/game/save", {params: {date: game.datetime, teams: game.teams}});
    },
    get: function(playerId) {
      return $http.get(dataSource + "/players/get-by-id", {params: {id: playerId}});
    },
    setSelectedPlayers: function(players) {
      selectedPlayers = players;
    },
    getSelectedPlayers: function() {
      return selectedPlayers;
    },
    setTeamsCount: function(count) {
      teamsCount = count;
    },
    getTeamsCount: function() {
      return teamsCount;
    },
    setBalanceWithParent: function(param) {
      balanceWithParent = param;
    },
    getBalanceWithParent: function() {
      return balanceWithParent;
    }
  };
});
