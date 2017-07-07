import {Component} from '@angular/core';

import {LoadingController, NavController, NavParams} from 'ionic-angular';

import {RestProvider} from "../../providers/rest/rest";
import {Model} from "../../services/model";

@Component({
  selector: 'page-teams',
  templateUrl: 'teams.html'
})
export class TeamsPage {

  private loading: any;
  private players: any;
  errorMessage: string;
  teams: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, public restProvider: RestProvider, public loadingCtrl: LoadingController, private model: Model) {
    this.players = this.navParams.get('players');
  }

  ionViewWillEnter() {
    this.loading = this.loadingCtrl.create({
      content: 'Loading...'
    });

    this.loading.present();
    this.makeTeams();
  }

  makeTeams() {
    this.restProvider.makeTeams(this.players, this.model.teamsCount, this.model.balanceWithParent)
      .subscribe(
        teams => this.teams = teams,
        error => {this.errorMessage = <any>error; this.loading.dismiss();},
        () => {this.loading.dismiss();});
  }

}
