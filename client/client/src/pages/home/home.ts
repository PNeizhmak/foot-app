import { Component } from '@angular/core';
import {SharedService} from "../../services/shared-service";

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  constructor(public sharedService: SharedService) {

  }

  saveModel(count) {
    this.sharedService.data = count;
  }
}
