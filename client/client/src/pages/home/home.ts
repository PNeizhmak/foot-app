import {Component} from '@angular/core';
import {Model} from "../../services/model";

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  constructor(public model: Model) {

  }

  saveTeamsCount(teamsCount) {
    this.model.teamsCount = teamsCount;
  }

  saveBalanceWithParent(balanceWithParent) {
    this.model.balanceWithParent = balanceWithParent;
  }
}
