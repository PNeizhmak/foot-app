angular.module('starter.services', [])

.factory('Players', function($http) {

  var players = [{
    id: 0,
    name: 'Pavel Neizhmal',
    lastText: 'You on your way?',
    face: 'img/ben.png'
  }, {
    id: 1,
    name: 'Max Egoshin',
    lastText: 'Hey, it\'s me',
    face: 'img/max.png'
  }];

  var dataSource = 'http://localhost:8080/players/all';

  return {
    all: function() {
      return $http.get(dataSource);
    },
    remove: function(player) {
      players.splice(players.indexOf(player), 1);
    },
    get: function(playerId) {
      for (var i = 0; i < players.length; i++) {
        if (players[i].id === parseInt(playerId)) {
          return players[i];
        }
      }
      return null;
    }
  };
});
