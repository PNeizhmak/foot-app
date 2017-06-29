import {Component} from '@angular/core';
import {NavController, NavParams} from 'ionic-angular';
import {RestProvider} from '../../providers/rest/rest';

@Component({
  selector: 'page-players',
  templateUrl: 'players.html'
})
export class PlayersPage {
  private players: any;
  errorMessage: string;

  private playersSearchBar: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, public restProvider: RestProvider) {
  }

  ionViewDidLoad() {
    this.getPlayers();
  }

  getPlayers() {
    this.restProvider.getPlayers()
      .subscribe(
        players => this.players = players,
        error => this.errorMessage = <any>error,
        () => this.initializeItems());
  }

  initializeItems() {
    this.playersSearchBar = this.players;
  }

  getPlayersSearchBar(ev: any) {

    this.initializeItems();

    let val = ev.target.value;

    if (val && val.trim() != '') {
      this.playersSearchBar = this.playersSearchBar.filter((p) => {
        return (p.name.toLowerCase().indexOf(val.toLowerCase()) > -1);
      })
    }
  }
}
