import {Injectable} from '@angular/core';

@Injectable()
export class Model {

  public teamsCount: number;
  public balanceWithParent: boolean;

  constructor() {
    this.teamsCount = 2;
    this.balanceWithParent = false;
  }

}
