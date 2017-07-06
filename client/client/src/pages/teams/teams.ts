import { Component } from '@angular/core';

import {NavController, NavParams} from 'ionic-angular';

import { PlayersPage } from '../players/players';
import {RestProvider} from "../../providers/rest/rest";

@Component({
  selector: 'page-teams',
  templateUrl: 'teams.html'
})
export class TeamsPage {
  icons: string[];
  items: Array<{title: string, note: string, icon: string}>;
  errorMessage: string;
  private teams: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, public restProvider: RestProvider) {
    this.icons = ['flask', 'wifi', 'beer', 'football', 'basketball', 'paper-plane',
    'american-football', 'boat', 'bluetooth', 'build'];

    this.items = [];
    for(let i = 1; i < 11; i++) {
      this.items.push({
        title: 'Item ' + i,
        note: 'This is item #' + i,
        icon: this.icons[Math.floor(Math.random() * this.icons.length)]
      });
    }
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

  itemTapped(event, item) {
    this.navCtrl.push(PlayersPage, {
      item: item
    });
  }
}
