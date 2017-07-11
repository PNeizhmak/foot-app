import {Component} from '@angular/core';

import {NavController, NavParams, ViewController} from 'ionic-angular';

@Component({
  selector: 'teams-modal',
  templateUrl: 'modal.html'
})
export class ModalPage {

  public event = {
    month: '2017-07-12',
    timeStarts: '20:00'
  };

  constructor(public navCtrl: NavController, public navParams: NavParams, public viewCtrl: ViewController) {
  }

  save() {
  }

  dismiss() {
    this.viewCtrl.dismiss();
  }
}
