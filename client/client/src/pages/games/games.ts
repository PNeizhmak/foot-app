import {Component} from '@angular/core';

import {ModalController, NavController, NavParams, ToastController} from 'ionic-angular';

import {RestProvider} from '../../providers/rest/rest';
import {GameModalPage} from "./modal/game-modal";

@Component({
  selector: 'page-games',
  templateUrl: 'games.html'
})
export class GamesPage {

  private games: any;
  private errorMessage: string;

  constructor(public navCtrl: NavController, public navParams: NavParams, public restProvider: RestProvider, public toastCtrl: ToastController, public modalCtrl: ModalController) {
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

  viewGameDetails(game) {
    let modal = this.modalCtrl.create(GameModalPage, {gameId: game.id});
    modal.present();
  }
}
