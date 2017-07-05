import {Injectable} from '@angular/core';

@Injectable()
export class SharedService {

  data: number;


  constructor() {
    this.data = 2;
  }

}
