import {Component} from '@angular/core';

import {NavController, NavParams} from 'ionic-angular';

import {RestProvider} from '../../providers/rest/rest';

@Component({
  selector: 'page-games',
  templateUrl: 'games.html'
})
export class GamesPage {

  private games: any;
  private errorMessage: string;

  constructor(public navCtrl: NavController, public navParams: NavParams, public restProvider: RestProvider) {
  }

  ionViewDidLoad() {
    this.getGames();
  }

  getGames() {
    this.restProvider.getGames()
      .subscribe(
        games => this.games = games,
        error => this.errorMessage = <any>error
      );
  }
}
