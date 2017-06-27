import {Component} from '@angular/core';
import {NavController, NavParams} from 'ionic-angular';
import {RestProvider} from '../../providers/rest/rest';

@Component({
  selector: 'page-players',
  templateUrl: 'players.html'
})
export class PlayersPage {
  players: string[];
  errorMessage: string;

  constructor(public navCtrl: NavController, public navParams: NavParams, public restProvider: RestProvider) {
  }

  ionViewDidLoad() {
    this.getPlayers();
  }

  getPlayers() {
    this.restProvider.getPlayers()
      .subscribe(
        players => this.players = players,
        error => this.errorMessage = <any>error);
  }
}
