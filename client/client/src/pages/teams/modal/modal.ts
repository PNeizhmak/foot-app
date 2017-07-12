import {Component} from '@angular/core';

import {NavController, NavParams, ViewController} from 'ionic-angular';

import {RestProvider} from "../../../providers/rest/rest";
import {GamesPage} from "../../games/games";

@Component({
  selector: 'teams-modal',
  templateUrl: 'modal.html'
})
export class ModalPage {

  private errorMessage: string;

  public game: any;
  public teams: any;

  public event = {
    date: new Date().toISOString().slice(0,10),
    timeStarts: '20:00'
  };

  constructor(public navCtrl: NavController, public navParams: NavParams, public viewCtrl: ViewController, public restProvider: RestProvider) {
    this.teams = navParams.get('teams');
  }

  saveGame() {
    this.game = {
      date: this.event.date.concat(" ").concat(this.event.timeStarts),
      teams: this.teams
    };

    this.restProvider.saveGame(this.game)
      .subscribe(
        result => {
          console.log('Ok');
          this.navCtrl.push(GamesPage)
        },
        error => this.errorMessage = <any>error
      );
  }

  dismiss() {
    this.viewCtrl.dismiss();
  }
}
