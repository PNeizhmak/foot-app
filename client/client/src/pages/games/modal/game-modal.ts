import {Component} from '@angular/core';

import {NavController, NavParams, ViewController} from 'ionic-angular';

import {RestProvider} from "../../../providers/rest/rest";

@Component({
  selector: 'game-modal',
  templateUrl: 'game-modal.html'
})
export class GameModalPage {

  private errorMessage: string;
  private gameId: number;
  private teams: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, public viewCtrl: ViewController, public restProvider: RestProvider) {
    this.gameId = navParams.get('gameId');
  }

  ionViewDidLoad() {
    this.getTeamsByGameId();
  }

  getTeamsByGameId() {
    this.restProvider.getTeamsByGameId(this.gameId)
      .subscribe(
        teams => this.teams = teams,
        error => this.errorMessage = <any>error
      );
  }

  dismiss() {
    this.viewCtrl.dismiss();
  }
}
