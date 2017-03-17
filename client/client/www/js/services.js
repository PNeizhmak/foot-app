angular.module('starter.services', [])

.factory('Players', function($http) {

  var dataSource = 'http://localhost:8080/players';

  return {
    all: function() {
      return $http.get(dataSource + "/all");
    },
    remove: function(player) {
      players.splice(players.indexOf(player), 1);
    },
    get: function(playerId) {
      return $http.get(dataSource + "/get-by-id", {params: {id: playerId}});
    }
  };
});
