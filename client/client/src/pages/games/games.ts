import {Component} from '@angular/core';

import {ItemSliding, NavController, NavParams, ToastController} from 'ionic-angular';

import {RestProvider} from '../../providers/rest/rest';

@Component({
  selector: 'page-games',
  templateUrl: 'games.html'
})
export class GamesPage {

  private games: any;
  private errorMessage: string;

  constructor(public navCtrl: NavController, public navParams: NavParams, public restProvider: RestProvider, public toastCtrl: ToastController) {
  }

  ionViewDidLoad() {
    this.presentToast('top');
    this.getGames();
  }

  getGames() {
    this.restProvider.getGames()
      .subscribe(
        games => this.games = games,
        error => this.errorMessage = <any>error
      );
  }

  presentToast(position: string) {
    let toast = this.toastCtrl.create({
      message: 'Slide game item for options <<<',
      duration: 3000,
      position: position
    });
    toast.present();
  }

  viewGameDetails() {
  }
}
