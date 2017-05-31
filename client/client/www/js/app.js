angular.module('starter', ['ionic', 'starter.controllers', 'starter.services'])

  .run(function ($ionicPlatform) {
    $ionicPlatform.ready(function () {
      if (window.cordova && window.cordova.plugins && window.cordova.plugins.Keyboard) {
        cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
        cordova.plugins.Keyboard.disableScroll(true);

      }
      if (window.StatusBar) {
        StatusBar.styleDefault();
      }
    });
  })

  .config(function ($stateProvider, $urlRouterProvider) {

    $stateProvider

      .state('app', {
        url: '/app',
        abstract: true,
        templateUrl: 'templates/menu.html'
      })

      .state('app.dash', {
        url: '/dash',
        views: {
          'menuContent': {
            templateUrl: 'templates/tab-dash.html',
            controller: 'DashCtrl'
          }
        }
      })

      .state('app.players', {
        url: '/players',
        views: {
          'menuContent': {
            templateUrl: 'templates/tab-players.html',
            controller: 'PlayersCtrl'
          }
        }
      })
      .state('app.teams', {
        url: '/teams',
        views: {
          'menuContent': {
            templateUrl: 'templates/tab-teams.html',
            controller: 'TeamsCtrl'
          }
        }
      })
      .state('app.games', {
        url: '/games',
        views: {
          'menuContent': {
            templateUrl: 'templates/tab-games.html',
            controller: 'GamesCtrl'
          }
        }
      })
      .state('tab.player-detail', {
        url: '/players/:playerId',
        views: {
          'tab-players': {
            templateUrl: 'templates/player-detail.html',
            controller: 'PlayerDetailCtrl'
          }
        }
      });

    $urlRouterProvider.otherwise('/app/dash');

  });
