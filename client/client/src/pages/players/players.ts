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
  private selectedPlayers = [];

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

    this.playersSearchBar.forEach((p) => {
      this.selectedPlayers.forEach((selected) => {
        if ((p.name) == (selected.name)) {
          p.selected = true;
        }
      });
    });
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

  toggleSelected(p) {
    if (p.selected) {
      this.selectedPlayers.push(p);
      console.log(this.selectedPlayers);
    }
    else {
      this.selectedPlayers.pop();
      console.log(this.selectedPlayers);
    }
  }
}
