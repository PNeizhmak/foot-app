import {Component} from '@angular/core';

import {NavController, NavParams} from 'ionic-angular';

import {RestProvider} from "../../providers/rest/rest";

@Component({
  selector: 'page-teams',
  templateUrl: 'teams.html'
})
export class TeamsPage {

  private players: any;
  private teams: any;

  errorMessage: string;

  constructor(public navCtrl: NavController, public navParams: NavParams, public restProvider: RestProvider) {
    this.players = this.navParams.get('players');
  }

  ionViewDidLoad() {
    this.makeTeams();
  }

  makeTeams() {
    this.restProvider.makeTeams()
      .subscribe(
        teams => this.teams = teams,
        error => this.errorMessage = <any>error);
  }

}
