import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class RestProvider {

  private serverUrl = 'http://10.61.20.56:8080';
  private playersAllUrl = this.serverUrl + '/players/all';
  private makeTeamsUrl = this.serverUrl + '/team-balancer/makeTeams';

  constructor(public http: Http) {
    console.log('Init RestProvider');
  }

  getPlayers(): Observable<string[]> {
    return this.http.get(this.playersAllUrl)
      .map(RestProvider.extractData)
      .catch(RestProvider.handleError);
  }

  makeTeams(): Observable<string[]> {
    return this.http.get(this.makeTeamsUrl)
      .map(RestProvider.extractData)
      .catch(RestProvider.handleError);
  }

  private static extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

  private static handleError(error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
