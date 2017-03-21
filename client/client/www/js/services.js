angular.module('starter.services', [])

.factory('Players', function($http) {

  var dataSource = 'http://localhost:8080/';

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
      var teamsCount = 2;
      return $http.get(dataSource + "/team-balancer/makeTeams", {params: {playerIds: ids, teamsCount: teamsCount}});
    },
    get: function(playerId) {
      return $http.get(dataSource + "/players/get-by-id", {params: {id: playerId}});
    }
  };
});
